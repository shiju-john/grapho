package com.flytxt.grapho.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.flytxt.grapho.exception.ApiError;
import com.flytxt.grapho.exception.GraphoException;
/**
 * 
 * @author shijuj
 *
 * @param <FlyEntity>
 */
@Controller
public class GraphoController<FlyEntity> {
	
	/**
	 * 
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<FlyEntity> getErrorResponse(GraphoException e) {
		ApiError  error = new ApiError(HttpStatus.BAD_REQUEST,e.getLocalizedMessage());
		return new ResponseEntity<FlyEntity>((FlyEntity)error,HttpStatus.BAD_REQUEST);
		
	}

}
