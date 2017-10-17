package com.flytxt.grapho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flytxt.grapho.entity.JobDetails;
import com.flytxt.grapho.entity.ResultEntity;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.service.JobService;

/**
 * 
 * @author shijuj
 *
 */
@RequestMapping(path="/job")
@Controller
@CrossOrigin(origins ="*")
public class JobExecutor  extends GraphoController<ResultEntity> {
	
	
	@Autowired
	private JobService jobService;
	
	@GetMapping(path="/executeJob/{id}") 
	public ResponseEntity<ResultEntity> executeJob (@PathVariable("id") Long id){		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setJobId(id);		
		try {			
			return new ResponseEntity<>(jobService.executeJob(jobDetails),HttpStatus.OK);
		} catch (GraphoException e) {
			return super.getErrorResponse(e);
		}	
	}

}
