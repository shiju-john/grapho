package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.flytxt.grapho.dao.ConnectorMetaDAO;
import com.flytxt.grapho.entity.ConnectorInstance;
import com.flytxt.grapho.entity.ConnectorMetaData;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.flytxt.grapho.filter.FilterUtils;
import com.querydsl.core.types.Predicate;

/**
 * @author shiju.john
 *
 */
@Service
public class ConnectorMetaService extends AbstractService<ConnectorMetaData, FilterCriteria>{

	private ConnectorMetaDAO dao;
	
	@Autowired
	private ConnectorService connectorService;

	@Autowired
	public ConnectorMetaService(ConnectorMetaDAO dao) {
		super(dao);
		this.dao = dao;
	}
	
	@Override
	public ConnectorMetaData delete(ConnectorMetaData entity) throws GraphoException {

		Iterable<ConnectorInstance> configData = connectorService
				.search(FilterUtils.getFilterCriteriaList("connectorRefId", "=", "" + entity.getId()));
		if (null != configData && configData.iterator().hasNext()) {
			throw new GraphoException("error.connectormeta.referenceFound", null);
		}
		return super.delete(entity);
	}

	/**
	 * 
	 * @param connectorMetaData
	 * @return
	 * @throws GraphoException
	 */
	@Override
	public ConnectorMetaData get(ConnectorMetaData connectorMetaData) throws GraphoException {
		return dao.get(connectorMetaData.getConnectorMetaId());
	}

	@Override
	public Iterable<ConnectorMetaData> search(List<FilterCriteria> criterias) throws GraphoException {
		Predicate predicate = super.getPredicate(ConnectorMetaData.class, "connectorMetaData", criterias);
		return dao.findAll(predicate);
	}
	
	@Override
	public Pages<ConnectorMetaData> search(List<FilterCriteria> criterias, int pageNo, int pageSize, String sortField,
			String sortOrder) throws GraphoException {
		Predicate predicate = super.getPredicate(ConnectorMetaData.class, "connectorMetaData", criterias);
		Page<ConnectorMetaData> page = dao.findAll(predicate,super.getPageRequest(pageNo, pageSize, sortField, sortOrder));
		return getPaginationResult(page);
	}


}
