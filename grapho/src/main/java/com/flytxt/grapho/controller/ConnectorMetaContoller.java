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

import com.flytxt.grapho.entity.ConnectorMetaData;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.flytxt.grapho.service.ConnectorMetaService;

/**
 * 
 * @author shiju.john
 *
 */
@Controller
@CrossOrigin(origins ="*")
@RequestMapping(path="/connector/meta")
public class ConnectorMetaContoller extends GraphoController<ConnectorMetaData>{
	
	
	@Autowired
	ConnectorMetaService service;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ConnectorMetaData> addInstanace(@RequestBody @Valid ConnectorMetaData connectorInstance)
			throws GraphoException {
		connectorInstance = service.save(connectorInstance);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
	/***
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<ConnectorMetaData>> finadAll() throws GraphoException {
		Iterable<ConnectorMetaData> connectorInstance = service.findAll();
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param connectorId
	 * @return
	 */
	@RequestMapping(path = "/{connectorMetaId}", method = RequestMethod.GET)
	public ResponseEntity<ConnectorMetaData> getConnector(@PathVariable("connectorMetaId") Long connectorId)
			throws GraphoException {
		ConnectorMetaData connectorMetaData = new ConnectorMetaData();
		connectorMetaData.setConnectorMetaId(connectorId);
		connectorMetaData = service.get(connectorMetaData);
		return new ResponseEntity<>(connectorMetaData, HttpStatus.OK);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/{connectorMetaId}", method = RequestMethod.DELETE)
	public ResponseEntity<ConnectorMetaData> deleteConnector(@PathVariable("connectorMetaId") Long id)
			throws GraphoException {
		ConnectorMetaData connectorMetaData = new ConnectorMetaData();
		connectorMetaData.setConnectorMetaId(id);
		connectorMetaData = service.delete(connectorMetaData);
		return new ResponseEntity<>(connectorMetaData, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<ConnectorMetaData> updateConnector(@RequestBody @Valid ConnectorMetaData connectorMetaData)
			throws GraphoException {
		connectorMetaData = service.update(connectorMetaData);
		return new ResponseEntity<>(connectorMetaData, HttpStatus.OK);
	}

	 /**
	  * 
	  * @param pageNo
	  * @param pageSize
	  * @param sortField
	  * @param sortOrder
	  * @return
	  * @throws GraphoException
	  */
	@RequestMapping(value = "/page", params = { "pageNo", "pageSize", "sortField",
			"sortOrder" }, method = RequestMethod.GET)
	public ResponseEntity<Pages<ConnectorMetaData>> findPage(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("pageSize") Integer pageSize, @RequestParam("sortField") String sortField,
			@RequestParam("sortOrder") String sortOrder) throws GraphoException {
		Pages<ConnectorMetaData> connectorMetaDetails = service.findPage(pageNo, pageSize, sortField, sortOrder);
		return new ResponseEntity<>(connectorMetaDetails, HttpStatus.OK);

	}
	
	/**
	 * 
	 * @param filterCriteria
	 * @return
	 * @throws GraphoException
	 */
	@RequestMapping(path="/filter", method = RequestMethod.POST)
	public ResponseEntity<Iterable<ConnectorMetaData>> search(@RequestBody @Valid List<FilterCriteria> filterCriteria)
			throws GraphoException {
		Iterable<ConnectorMetaData> connectorInstance = service.search(filterCriteria);
		return new ResponseEntity<>(connectorInstance, HttpStatus.OK);
	}
	
}
