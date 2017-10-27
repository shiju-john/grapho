package com.flytxt.grapho.commons.zeppelin;

import com.flytxt.grapho.exception.ZeppelinException;
/**
 * 
 * @author shiju.john
 *
 */
public interface ZeppelinApiClient {
	/**
	 * 
	 * @param noteBookId
	 * @return
	 * @throws ZeppelinException
	 */
	public String deleteNote(String noteBookId) throws ZeppelinException;
	
	public String runNote(String noteId)throws ZeppelinException;

}
