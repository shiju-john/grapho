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
 * @param <FlyEntity>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class FlyDao<FlyEntity> {
	
	private static final Logger logger = LoggerFactory.getLogger(FlyDao.class);	
	private CrudRepository crudRepository;
	
	
	public FlyDao(CrudRepository crudRepository){
		this.crudRepository = crudRepository;
	}
	
	/**
	 * 
	 * @param entity
	 * @return
	 * @throws GraphoException
	 */

	public FlyEntity save(FlyEntity entity)  throws GraphoException{
		try {
			return (FlyEntity)crudRepository.save(entity);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			throw new GraphoException(e.getMessage(),e);
		}
	}
	
	public FlyEntity update(FlyEntity entity)  throws GraphoException{
		try {
			
			return (FlyEntity)crudRepository.save(entity);
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
	public FlyEntity get(Serializable entity) throws GraphoException{ 
		try {
			FlyEntity flyEntity  = (FlyEntity)crudRepository.findOne(entity);
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
	 * @param jobDetails
	 * @return
	 */
	public void delete(FlyEntity entity) {
		 crudRepository.delete(entity);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public Iterable<FlyEntity> findAll() {
		return crudRepository.findAll();
	}
	
	
	/**
	 * 
	 * @param exp
	 * @param pageRequest
	 * @return
	 */	
	public Page<FlyEntity> findAll(Predicate exp, PageRequest pageRequest) {
		return ((QueryDslPredicateExecutor)crudRepository).findAll(exp,pageRequest);
	}
	
	/**
	 * 
	 * @param predicate
	 * @return
	 */
	public Iterable<FlyEntity> findAll(Predicate predicate) {
		return ((QueryDslPredicateExecutor)crudRepository).findAll(predicate);		
	}
	
	/**
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Page<FlyEntity> findPage(PageRequest pageRequest) {		
		return ((PagingAndSortingRepository)crudRepository).findAll(pageRequest);
	}


}
