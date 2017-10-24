package com.flytxt.grapho.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flytxt.grapho.entity.ConnectorMetaData;
/**
 * 
 * @author shiju.john
 *
 */

public interface ConnectorMetaRepository extends CrudRepository<ConnectorMetaData, Long>,
					PagingAndSortingRepository<ConnectorMetaData, Long> ,
					QueryDslPredicateExecutor<ConnectorMetaData> {

}
