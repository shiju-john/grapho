package com.flytxt.grapho.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flytxt.grapho.exception.GraphoException;
import com.querydsl.core.types.Predicate;
/**
 * 
 * @author shiju.john
 *
 * @param <GraphoEntity>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class GraphoDao<GraphoEntity> {
	
	private static final Logger logger = LoggerFactory.getLogger(GraphoDao.class);	
	private CrudRepository crudRepository;
	
	
	public GraphoDao(CrudRepository crudRepository){
		this.crudRepository = crudRepository;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws GraphoException
	 */

	public GraphoEntity save(GraphoEntity entity)  throws GraphoException{
		try {
			return (GraphoEntity)crudRepository.save(entity);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new GraphoException(e.getMessage(),e);
		}
	}
	
	public GraphoEntity update(GraphoEntity entity)  throws GraphoException{
		try {
			
			return (GraphoEntity)crudRepository.save(entity);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new GraphoException(e.getMessage(),e);
		}
	}
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws GraphoException
	 */
	public GraphoEntity get(Serializable entity) throws GraphoException{ 
		try {
			GraphoEntity flyEntity  = (GraphoEntity)crudRepository.findOne(entity);
			if(null==flyEntity)
				throw new GraphoException("error.common.notfound", null);			
			return flyEntity;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new GraphoException(e.getMessage(),e);
		}		
	} 
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws GraphoException
	 */
	public boolean isExists(Serializable id) throws GraphoException {
		return crudRepository.exists(id);		
	}
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 */
	public void delete(GraphoEntity entity) throws GraphoException{		
		 crudRepository.delete(entity);	
	}
	
	/**
	 * 
	 * @return
	 */
	
	public Iterable<GraphoEntity> findAll() {
		return crudRepository.findAll();
	}
	
	
	/**
	 * 
	 * @param exp
	 * @param pageRequest
	 * @return
	 */	
	public Page<GraphoEntity> findAll(Predicate exp, PageRequest pageRequest)  throws GraphoException {
		Page<GraphoEntity> result= ((QueryDslPredicateExecutor)crudRepository).findAll(exp,pageRequest);
		return result;
	}
	
	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public Iterable<GraphoEntity> findAll(Predicate predicate) {
		Iterable<GraphoEntity> result= ((QueryDslPredicateExecutor)crudRepository).findAll(predicate);	
		return result;
	}
	
	/**
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Page<GraphoEntity> findPage(PageRequest pageRequest) {		
		Page<GraphoEntity> result= ((PagingAndSortingRepository)crudRepository).findAll(pageRequest);
		return result;
	}


}
