package com.flytxt.grapho.exception;

/**
 * 
 * @author shiju.john
 *
 */
public class GraphoException extends Exception {
	
	private String fieldName;
	
	/**
	 * 
	 * @param message
	 * @param e
	 */
	public GraphoException(String message, Exception e) {
		super(message,e);
	}

	public GraphoException(String message, Exception e, String fieldName) {
		super(message,e);
		this.setFieldName(fieldName);
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

	/**
	 * 
	 */
	private static final long serialVersionUID = -477618972636106421L;

}
