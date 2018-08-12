package com.chandni.productReview.model;

/**
 * Comment Classification response for rest API
 * isObjectionable should be true for objectionable content
 * contentType tells why is it objectionable (contains insult/ threat/ racism.. )
 * @author chandnimanwani
 *
 */
public class CommentClassResponse {
	
	private Boolean isObjectionable;
	private String contentType;
	
	
	public CommentClassResponse(Boolean isObjectionable, String contentType) {
		super();
		this.isObjectionable = isObjectionable;
		this.contentType = contentType;
	}
	
	public Boolean getIsObjectionable() {
		return isObjectionable;
	}
	public void setIsObjectionable(Boolean isObjectionable) {
		this.isObjectionable = isObjectionable;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	

}
