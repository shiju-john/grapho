package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.flytxt.grapho.commons.DbTypes;
import com.flytxt.grapho.dao.JobDAO;
import com.flytxt.grapho.entity.JobDetails;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.entity.ResultEntity;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.filter.FilterCriteria;
import com.querydsl.core.types.Predicate;
/**
 * 
 * @author shiju.john
 *
 */
@Service
public class JobService extends AbstractService<JobDetails, FilterCriteria> {
	
	
	private JobDAO dao;


	@Autowired
	public JobService(JobDAO dao) {
		super(dao);
		this.dao = dao;
	}
	
	
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 * @throws GraphoException
	 */
	public JobDetails get(JobDetails jobDetails) throws GraphoException{
		return dao.get(jobDetails); 
	}
	
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 * @throws GraphoException
	 */
	public ResultEntity executeJob(JobDetails jobDetails) throws GraphoException {
		jobDetails =  dao.get(jobDetails);
		DbTypes dbTypes = DbTypes.getDbType(jobDetails.getDbType());
		return dbTypes.executeQuery(jobDetails);		
	}
	
		
	@Override
	public Iterable<JobDetails> search(List<FilterCriteria> criterias) throws GraphoException {
		Predicate predicate = super.getPredicate(JobDetails.class, "jobDetails", criterias);
		return dao.findAll(predicate);
	}
	
	@Override
	public Pages<JobDetails> search(List<FilterCriteria> criterias, int pageNo, int pageSize, String sortField,
			String sortOrder) throws GraphoException {
		Predicate predicate = super.getPredicate(JobDetails.class, "jobDetails", criterias);
		Page<JobDetails> page = dao.findAll(predicate,super.getPageRequest(pageNo, pageSize, sortField, sortOrder));
		return getPaginationResult(page);
	}
	

}
