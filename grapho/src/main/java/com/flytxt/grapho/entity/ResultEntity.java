package com.flytxt.grapho.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

/**
 * 
 * @author shijuj
 *
 */
public class ResultEntity implements FlyEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<String[]> result;
	private String[] header;

	


	/**
	 * @return the result
	 */
	public List<String[]> getResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(List<String[]> result) {
		this.result = result;
	}


	/**
	 * @return the header
	 */
	public String[] getHeader() {
		return header;
	}


	/**
	 * @param header the header to set
	 */
	public void setHeader(String[] header) {
		this.header = header;
	}


	@Override
	@Transient
	public Serializable getId() {
		return null;
	}


	

}
