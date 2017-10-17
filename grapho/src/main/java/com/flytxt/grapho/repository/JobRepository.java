package com.flytxt.grapho.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.flytxt.grapho.entity.ConnectorInstance;
import com.flytxt.grapho.entity.JobDetails;
/**
 * 
 * @author shiju.john
 *
 */
public interface JobRepository  extends CrudRepository<JobDetails, Long> ,
					PagingAndSortingRepository<JobDetails, Long>,
					QueryDslPredicateExecutor<ConnectorInstance>{

}

