package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.flytxt.grapho.dao.ConnectorDAO;
import com.flytxt.grapho.dao.ConnectorMetaDAO;
import com.flytxt.grapho.entity.ConnectorInstance;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.querydsl.core.types.Predicate;

/**
 * 
 * @author shiju.john
 *
 */
@Service
public class ConnectorService extends AbstractService<ConnectorInstance,FilterCriteria> {
	
	
	private ConnectorDAO dao;
	
	@Autowired
	private ConnectorMetaDAO metaDao;
	
	@Autowired
	public ConnectorService(ConnectorDAO dao){
		super(dao);
		this.dao = dao;
	}
	
	
	@Override
	public boolean validate(ConnectorInstance entity) throws GraphoException {
		if (!metaDao.isExists(entity.getConnectorRefId())){
			throw new GraphoException("error.connectorinstance.metaNotFound", null,"connectorRefId");
		}
		return true;
	};
	
	/**
	 * 
	 * @param connectorInstance
	 * @return
	 * @throws GraphoException
	 */
	public ConnectorInstance get(ConnectorInstance connectorInstance) throws GraphoException{
		return dao.get(connectorInstance.getInstanceId()); 
	}
	
	/**
	 * 
	 * @param filterCriteria
	 * @return
	 */
	public Iterable<ConnectorInstance> search(List<FilterCriteria> criterias) throws GraphoException {
		Predicate predicate = super.getPredicate(ConnectorInstance.class, "connectorInstance", criterias);
		return dao.findAll(predicate);
	}
	
	/**
	 * 
	 */
	public Pages<ConnectorInstance> search(List<FilterCriteria> criterias, int pageNo, int pageSize, String sortField,
			String sortOrder) throws GraphoException {
		Predicate predicate = super.getPredicate(ConnectorInstance.class, "connectorInstance", criterias);
		Page<ConnectorInstance> page = dao.findAll(predicate,super.getPageRequest(pageNo, pageSize, sortField, sortOrder));
		return getPaginationResult(page);
	}

}
