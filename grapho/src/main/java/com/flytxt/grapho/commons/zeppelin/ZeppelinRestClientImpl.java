package com.flytxt.grapho.commons.zeppelin;

import java.util.HashMap;
import java.util.Map;

import com.flytxt.grapho.commons.RestConnector;
import com.flytxt.grapho.exception.ZeppelinException;
/**
 * 
 * @author shiju.john
 *
 */
public class ZeppelinRestClientImpl implements ZeppelinApiClient{
	
	private String baseUri ;
	
	
	public ZeppelinRestClientImpl(String baseUri){
		this.baseUri= baseUri;
	}
	
	
	
	@Override
	public String deleteNote(String noteId) throws ZeppelinException {
		String deleteUrl = baseUri+"/notebook/{noteId}";
		Map<String,String> pathVariables= new HashMap<>();
		pathVariables.put("noteId", noteId);
		RestConnector<String> connector = RestConnector.getInstance();
		try{
			return connector.invokeDeleteMethod(deleteUrl, pathVariables);
		}catch(Exception e){
			throw new ZeppelinException(e.getMessage(),e);
		}
	}
	
	@Override
	public String runNote(String noteId)throws ZeppelinException{
		String executeUrl = baseUri+"/notebook/job/{noteId}";
		Map<String,String> pathVariables= new HashMap<>();
		pathVariables.put("noteId", noteId);
		RestConnector<String> connector = RestConnector.getInstance();
		try{
			return connector.invokePostMethod(executeUrl,null,String.class, pathVariables);
		}catch(Exception e){
			throw new ZeppelinException(e.getMessage(),e);
		}
	}

}
