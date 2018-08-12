package com.chandni.productReview.api;

import com.chandni.productReview.model.Comment;
import com.chandni.productReview.model.CommentClassResponse;

/**
 * API contract to classify objectionable content in a comment
 * @author chandnimanwani
 *
 */
public interface ICommentClassifier {
	
	/**
	 * Comment Classifier Contract - accepts JSON representation of Comment
	 * Return JSON is comment objectionable and the objection class type(Threat, Insult etc)
	 * @param comment
	 * @return
	 */
	public CommentClassResponse checkObjectionableContent(Comment comment);

}
