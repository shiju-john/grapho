package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.flytxt.grapho.dao.ConfigDao;
import com.flytxt.grapho.entity.ConfigData;
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
public class ConfigService extends AbstractService<ConfigData, FilterCriteria>{
	
	private ConfigDao<ConfigData> dao;
	
	@Autowired
	public ConfigService(ConfigDao<ConfigData> dao) {
		super(dao);	
		this.dao = dao;
	}

	@Override
	public ConfigData get(ConfigData entity) throws GraphoException {
		return dao.get(entity.getKey());
	}

	@Override
	public Pages<ConfigData> search(List<FilterCriteria> criterias, int pageNo, int pageSize, String sortField,
			String sortOrder) throws GraphoException {		
		Predicate predicate = super.getPredicate(ConfigData.class, "configData", criterias);
		Page<ConfigData> page = dao.findAll(predicate,super.getPageRequest(pageNo, pageSize, sortField, sortOrder));
		return getPaginationResult(page);
	}

	@Override
	public Iterable<ConfigData> search(List<FilterCriteria> criterias) throws GraphoException {
		Predicate predicate = super.getPredicate(ConfigData.class, "configData", criterias);
		return dao.findAll(predicate);
	}

}
