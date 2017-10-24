package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import com.flytxt.grapho.dao.GraphoDao;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.flytxt.grapho.filter.PredicatesBuilder;
import com.querydsl.core.types.Predicate;
/**
 * 
 * @author shiju.john
 *
 * @param <T>
 * @param <E> 
 */
public  abstract class AbstractService<T,E> implements GraphoService<T,E>{

	private GraphoDao<T> dao;
	
	public AbstractService(GraphoDao<T> dao){
		this.dao = dao;
	}
	
	
	@SuppressWarnings("rawtypes")	
	public Predicate getPredicate(Class classType, String aliaceName,List<FilterCriteria> criterias) {
		PredicatesBuilder builder = new PredicatesBuilder();
		for(FilterCriteria criteria : criterias ){
			builder.with(criteria);
		}
		return  builder.build(classType,aliaceName);
	}	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @return 
	 */
	protected PageRequest getPageRequest(int pageNo,int pageSize,String sortField, String sortOrder){
		Direction direction =  null!=sortOrder ? "ASC".equalsIgnoreCase(sortOrder)?Direction.ASC:Direction.DESC:null;
		return new PageRequest(pageNo, pageSize,direction,sortField);
		
	}
	
	/**
	 * 
	 */
	@Override
	public T save(T entity)  throws GraphoException{
		return dao.save(entity);
	}
	
	@Override
	public T delete(T entity) throws GraphoException {
		if(dao.isExists(((com.flytxt.grapho.entity.GraphoEntity)entity).getId())){
			dao.delete(entity);
			return entity;
		}
		throw new GraphoException("error.common.notfound", null);
	}
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 * @throws GraphoException
	 */
	@Override
	public T update(T entity) throws GraphoException {
		if(dao.isExists(((com.flytxt.grapho.entity.GraphoEntity)entity).getId())){
			return dao.save(entity);
		}
		throw new GraphoException("error.common.notfound", null);
	}
	

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<T> findAll() {
		return dao.findAll();
	}

	@Override
	public Pages<T> findPage(int pageNo,int pageSize,String sortField, String sortOrder) throws GraphoException{
		Page<T> page =  dao.findPage(getPageRequest(pageNo, pageSize, sortField, sortOrder));
		return getPaginationResult(page);
	}
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	protected Pages<T> getPaginationResult(Page<T> page) {
		Pages<T> result =  new Pages<>();
		result.setContent(page.getContent());
		result.setTotalElement(page.getTotalElements());
		result.setTotalPage(page.getTotalPages());
		result.setHasPrevious(page.hasPrevious());
		result.setHasNext(page.hasNext());		
		return result;		
	}
}
