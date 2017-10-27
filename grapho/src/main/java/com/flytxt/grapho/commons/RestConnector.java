package com.flytxt.grapho.commons;

import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author shiju.john
 *
 * @param <T>
 */
public class RestConnector<T>  {
	
	private RestTemplate restTemplate;
	
	private static volatile RestConnector<String> me =null;
	
	private RestConnector(){
		restTemplate = new RestTemplate();		
	}
	
	/**
	 * 
	 * @return
	 */
	public static RestConnector<String> getInstance(){
		if(me==null){
			synchronized (RestConnector.class) {
				me = new RestConnector<String>();
			}
		}
		return me;		
	}
	
	
	/**
	 * 
	 * @param url
	 * @param responseType
	 * @param pathParam
	 * @return
	 * @throws Exception
	 */
	public T invokeGetMethod(String url,Class<T> responseType,Map<String,?> pathParam) throws Exception {
		return restTemplate.getForObject(url, responseType,pathParam);
	}
		
	/**
	 * 
	 * @param url
	 * @param request
	 * @param responseType
	 * @param pathPara
	 * @return
	 * @throws Exception
	 */
	public T invokePostMethod(String url, Object request,Class<T> responseType,Map<String,?> pathPara) throws Exception {
		return restTemplate.postForObject(url, request, responseType,pathPara);
	}
	 
	
	/**
	 * 
	 * @param url
	 * @param request
	 * @param pathParam
	 * @throws Exception
	 */
	public void invokePutMethod(String url,Object request,Map<String,?> pathParam) throws Exception{
		restTemplate.put(url, request, pathParam);
	}
	
	/**
	 * 
	 * @param url
	 * @param pathParam
	 * @throws Exception
	 */
	public String invokeDeleteMethod(String url,Map<String,?> pathParam) throws Exception {
		return restTemplate.execute(url, HttpMethod.DELETE, null, null,pathParam);
	}
	

}
