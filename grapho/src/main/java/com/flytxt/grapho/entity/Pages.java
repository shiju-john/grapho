package com.flytxt.grapho.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author shiju.john
 *
 */
public class Pages<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> content;	
	private int totalPage;
	private long totalElement;
	private boolean hasNext;
	private boolean hasPrevious;
	

	/**
	 * @return the content
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}

	
	/**
	 * @return the totalElement
	 */
	public long getTotalElement() {
		return totalElement;
	}

	/**
	 * @param totalElement the totalElement to set
	 */
	public void setTotalElement(long totalElement) {
		this.totalElement = totalElement;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the hasNext
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 * @param hasNext the hasNext to set
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * @return the hasPrevious
	 */
	public boolean isHasPrevious() {
		return hasPrevious;
	}

	/**
	 * @param hasPrevious the hasPrevious to set
	 */
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

}
