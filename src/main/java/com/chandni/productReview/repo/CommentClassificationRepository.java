package com.chandni.productReview.repo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Objectionable Comment classification corpus
 * Keep Adding for accurate Results
 */
public class CommentClassificationRepository {
	
	private static Set<String> insultCorpus;
	private static Set<String> obsceneCorpus;
 	private static Set<String> threatCorpus;
 	
	static{
		init();
	}
	
	/**
	 * Working with a sample set here
	 * Better the Corpus, Better the API Response
	 * Using this list as a static reference corpus
	 */
	private static void init() {
		insultCorpus = new HashSet<>(Arrays.asList("Bitch", "Idiot", "Moron"));
		obsceneCorpus = new HashSet<>(Arrays.asList("Dick", "Sex", "Fuck"));
		threatCorpus = new HashSet<>(Arrays.asList("Kill", "Butcher", "Murder"));
	}
	
	/*
	 * Returns set of words identified as insult
	 */
	public static Set<String> getInsultCorpus()
	{
		return insultCorpus;
	}

	/*
	 * Return Set of Words Identified as Racism
	 */
	public static Set<String> getObsceneCorpus()
	{
		return obsceneCorpus;
	}
	
	/*
	 * Returns set of Words Identified as Threat
	 */
	public static Set<String> getThreatCorpus()
	{
		return threatCorpus;
	}
	
	
}
