package com.flytxt.grapho.filter;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author shiju.john
 *
 */
public class FilterCriteria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String key;
	
	@NotNull
	private String operation;
	
	@NotNull
	private String value;

	
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	
}
