package com.chandni.productReview.api;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.chandni.productReview.model.Comment;
import com.chandni.productReview.model.CommentClassResponse;
import com.chandni.productReview.repo.CommentClassificationRepository;

/**
 * RestFul Web Service to classify objectionable Content
 * @author chandnimanwani
 *
 */
@Path("comment")
public class CommentClassifierImpl implements ICommentClassifier{

	@POST
	@Path("checkObjectionable")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	/*
	 * (non-Javadoc)
	 * @see com.chandni.productReview.api.ICommentClassifier#checkObjectionableContent(com.chandni.productReview.model.Comment)
	 */
	public CommentClassResponse checkObjectionableContent(Comment reviewComment) {
		
		String comment= reviewComment!=null ? reviewComment.getCommentStr() : null;
		
		CommentClassResponse commentClass = new CommentClassResponse(false, "Clean");
		
		// Check For any Insult / Threat / Racism
		if (checkInsult(comment, commentClass) || checkThreat(comment, commentClass)
				|| checkObscene(comment, commentClass)) {
			return commentClass;
		}
		//No Objectionable content found return clean class as response
		return commentClass;
	}

	/**
	 * Check If the comment has obscene content
	 * @param comment
	 * @param commentClass
	 * @return
	 */
	private boolean checkObscene(String comment ,CommentClassResponse commentClass) {
		//Get Obscene Corpus from repository
		Set<String> obsceneCorpus = CommentClassificationRepository.getObsceneCorpus();
		//Check If comment contains any obscene words
		if(checkCorpusInComment(obsceneCorpus, comment))
		{
			commentClass.setIsObjectionable(true);
			commentClass.setContentType("Obscene");
			return true;
		}
		return false;
	}

	/**
	 * Check If comment has any Threats
	 * @param comment
	 * @param commentClass
	 * @return
	 */
	private boolean checkThreat(String comment, CommentClassResponse commentClass) {
		//Get Threat Corpus from repository
		Set<String> threatCorpus = CommentClassificationRepository.getThreatCorpus();
		//Check If comment contains any threat words
		if(checkCorpusInComment(threatCorpus, comment)){
			commentClass.setIsObjectionable(true);
			commentClass.setContentType("Threat");
			return true;
		}
		return false;
	}

	/**
	 * Check if comment has any Insults
	 * @param comment
	 * @param commentClass
	 * @return
	 */
	private boolean checkInsult(String comment, CommentClassResponse commentClass) {
		//Get Insult Corpus from repository
		Set<String> insultCorpus = CommentClassificationRepository.getInsultCorpus();
		//Check If comment contains any insult words
		if(checkCorpusInComment(insultCorpus, comment)){
			commentClass.setIsObjectionable(true);
			commentClass.setContentType("Insult");
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if comment contains any word present in the set objectionable Corpus
	 * @param objectionableCorpus
	 * @param comment
	 * @return
	 */
	private Boolean checkCorpusInComment (Set<String> objectionableCorpus, String comment)
	{
		if(comment ==null || objectionableCorpus==null)
		{
			return false;
		}
		
		for(String objectionableWord : objectionableCorpus)
		{
			//Found the objectionable Word in comment
			if(comment.toLowerCase().indexOf(objectionableWord.toLowerCase())!=-1)
			{
				return true;
			}
		}
		return false;
	}

}
