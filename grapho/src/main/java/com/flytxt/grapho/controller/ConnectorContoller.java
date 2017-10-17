package com.flytxt.grapho.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flytxt.grapho.entity.ConnectorInstance;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.flytxt.grapho.service.ConnectorService;

/**
 * @author shiju.john
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/connector")
public class ConnectorContoller extends GraphoController<ConnectorInstance> {

	@Autowired
	private ConnectorService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ConnectorInstance> addInstanace(@RequestBody @Valid ConnectorInstance connectorInstance)
			throws GraphoException {
		connectorInstance = service.save(connectorInstance);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}

	/***
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<ConnectorInstance>> finadAll() throws GraphoException {
		Iterable<ConnectorInstance> connectorInstance = service.findAll();
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}

	/**
	 * 
	 * @param connectorId
	 * @return
	 */
	@RequestMapping(path = "/{connectorId}", method = RequestMethod.GET)
	public ResponseEntity<ConnectorInstance> getConnector(@PathVariable("connectorId") Long connectorId)
			throws GraphoException {
		ConnectorInstance connectorInstance = new ConnectorInstance();
		connectorInstance.setInstanceId(connectorId);
		connectorInstance = service.get(connectorInstance);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{connectorId}", method = RequestMethod.DELETE)
	public ResponseEntity<ConnectorInstance> deleteConnector(@PathVariable("connectorId") Long id)
			throws GraphoException {
		ConnectorInstance connectorInstance = new ConnectorInstance();
		connectorInstance.setInstanceId(id);
		connectorInstance = service.delete(connectorInstance);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);

	}

	/**
	 * 
	 * @param jobDetails
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ConnectorInstance> updateConnector(@RequestBody @Valid ConnectorInstance connectorInstance)
			throws GraphoException {
		connectorInstance = service.update(connectorInstance);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param filterCriteria
	 * @return
	 * @throws GraphoException
	 */
	@RequestMapping(path="/filter", method = RequestMethod.POST)
	public ResponseEntity<Iterable<ConnectorInstance>> search(@RequestBody @Valid List<FilterCriteria> filterCriteria)
			throws GraphoException {
		Iterable<ConnectorInstance> connectorInstance = service.search(filterCriteria);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
	
	
	/**
	 * 
	 * @param filterCriteria
	 * @return
	 * @throws GraphoException
	 */
	@RequestMapping(path="/filter",  params = { "pageNo", "pageSize","sortField","sortOrder" } , method = RequestMethod.POST)
	public ResponseEntity<Pages<ConnectorInstance>> search(@RequestBody @Valid List<FilterCriteria> filterCriteria,@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize,@RequestParam("sortField") String sortField,@RequestParam("sortOrder") String sortOrder)
			throws GraphoException {
		Pages<ConnectorInstance> connectorInstance = service.search(filterCriteria,pageNo, pageSize,sortField,sortOrder);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
			
	/**
	 *  
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/page", params = { "pageNo", "pageSize","sortField","sortOrder" }, method = RequestMethod.GET)
	public ResponseEntity<Pages<ConnectorInstance>> findPage(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize,@RequestParam("sortField") String sortField,@RequestParam("sortOrder") String sortOrder) throws GraphoException {
		Pages<ConnectorInstance> jobDetails = service.findPage(pageNo, pageSize,sortField,sortOrder);
		return new ResponseEntity<>(jobDetails, HttpStatus.OK);
	}

}
