package com.flytxt.grapho.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
/**
 * 
 * @author shiju.john
 *
 */
public class ApiError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Http error status 
	 */
	private String httpStatus ;
	
	/**
	 * Error Message 
	 */
	private String message;
	
	/**
	 * Message Type 
	 */
	private String messageType;
	
	/**
	 * Filed Name
	 */
	private String fieldName;
	
	
	
	
	/**
	 * 
	 * @param httpStatus
	 * @param localizedMessage
	 */
	public ApiError(HttpStatus httpStatus, String message) {
		this.setMessage(message);
		this.setHttpStatus(httpStatus.getReasonPhrase());
	}
	
	/**
	 * 
	 * @param error
	 * @param message
	 * @param field
	 * @param httpStatus
	 */
	public ApiError(MessageType error, String message, String field,HttpStatus httpStatus) {
		this.setFieldName(field);
		this.setHttpStatus(httpStatus.getReasonPhrase());
		this.setMessage(message);
		this.setMessageType(error.toString());
	}

	/**
	 * 
	 * @return
	 */
	public String getHttpStatus() {
		return httpStatus;
	}

	/**
	 * 
	 * @param httpStatus
	 */
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	

}
