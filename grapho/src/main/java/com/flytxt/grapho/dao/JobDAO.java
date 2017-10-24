package com.flytxt.grapho.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.flytxt.grapho.entity.JobDetails;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.repository.JobRepository;


/**
 * 
 * @author shiju.john
 *
 */
@Component
public class JobDAO extends GraphoDao<JobDetails> {
		
	private JobRepository  jobRepository;
	
	@Autowired
	JobDAO(JobRepository crudRepository) {
		super(crudRepository);
		this.jobRepository=crudRepository;
	}
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 * @throws GraphoException
	 */
	public JobDetails get(JobDetails jobDetails) throws GraphoException {
		return  super.get(jobDetails.getJobId());		
	}


	/**
	 * 
	 * @param pageRequest
	 * @return
	 */
	public Page<JobDetails> findPage(PageRequest pageRequest) {		
		return jobRepository.findAll(pageRequest);
	}

}
