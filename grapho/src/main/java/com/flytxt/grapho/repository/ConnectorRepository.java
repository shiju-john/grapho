package com.flytxt.grapho.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flytxt.grapho.entity.ConnectorInstance;
/**
 * 
 * @author shiju.john
 *
 */
public interface ConnectorRepository extends CrudRepository<ConnectorInstance, Long>,
					PagingAndSortingRepository<ConnectorInstance, Long>,
					QueryDslPredicateExecutor<ConnectorInstance> {
	

}
