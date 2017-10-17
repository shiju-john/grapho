package com.flytxt.grapho.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flytxt.grapho.entity.ConnectorMetaData;
import com.flytxt.grapho.repository.ConnectorMetaRepository;
/**
 * 
 * @author shiju.john
 *
 */
@Component
public class ConnectorMetaDAO extends FlyDao<ConnectorMetaData>{
	
	
	@Autowired
	ConnectorMetaDAO(ConnectorMetaRepository crudRepository) {
		super(crudRepository);
	}
	
}
