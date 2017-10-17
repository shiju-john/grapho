package com.flytxt.grapho.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flytxt.grapho.entity.ConnectorInstance;
import com.flytxt.grapho.repository.ConnectorRepository;
/**
 * 
 * @author shiju.john
 *
 */
@Component
public class ConnectorDAO extends FlyDao<ConnectorInstance>{

		
	@Autowired
	ConnectorDAO(ConnectorRepository connectorRepository) {
		super(connectorRepository);		
	}

}
