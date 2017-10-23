package com.flytxt.grapho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flytxt.grapho.entity.ConfigData;
import com.flytxt.grapho.filter.FilterCriteria;
import com.flytxt.grapho.service.ConfigService;
/**
 * 
 * @author shiju.john
 *
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/config")
public class ConfigController extends GraphoController<ConfigData>{
	
	@Autowired
	ConfigService service;
	
	@RequestMapping(path = "/zeppelin", method = RequestMethod.GET)
	public ResponseEntity<Iterable<ConfigData>> getZeppelinConfig()
			throws Exception {
		FilterCriteria criteria =  new FilterCriteria();
		criteria.setKey("type");
		criteria.setOperation("=");
		criteria.setValue("Zeppelin");
		List<FilterCriteria> criterias = new ArrayList<>();
		criterias.add(criteria);		
		Iterable<ConfigData>  configData = service.search(criterias);
		return new ResponseEntity<>(configData, HttpStatus.OK);
	}

}
