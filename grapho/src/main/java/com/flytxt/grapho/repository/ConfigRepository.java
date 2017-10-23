package com.flytxt.grapho.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flytxt.grapho.entity.ConfigData;

/**
 * 
 * @author shiju.john
 *
 */
public interface ConfigRepository extends CrudRepository<ConfigData, String>,
		PagingAndSortingRepository<ConfigData, String>, QueryDslPredicateExecutor<ConfigData> {

}
