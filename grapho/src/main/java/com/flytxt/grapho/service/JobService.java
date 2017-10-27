package com.flytxt.grapho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.flytxt.grapho.commons.zeppelin.ZeppelinApiClient;
import com.flytxt.grapho.commons.zeppelin.ZeppelinRestClientImpl;
import com.flytxt.grapho.dao.JobDAO;
import com.flytxt.grapho.entity.ConfigData;
import com.flytxt.grapho.entity.JobDetails;
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
public class JobService extends AbstractService<JobDetails, FilterCriteria> {
	
	
	private JobDAO dao;
	
	@Autowired
	ConfigService configService;


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
	
	
	public void  executeJob(JobDetails jobDetails) throws GraphoException {
		ConfigData  configData = configService.get(new ConfigData("ZeppelinRestURI"));
		ZeppelinApiClient apiClient  = new ZeppelinRestClientImpl(configData.getValue());
		apiClient.runNote("");
				
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
