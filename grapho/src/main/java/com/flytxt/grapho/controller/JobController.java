package com.flytxt.grapho.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flytxt.grapho.entity.JobDetails;
import com.flytxt.grapho.entity.Pages;
import com.flytxt.grapho.exception.GraphoException;
import com.flytxt.grapho.service.JobService;
/**
 * 
 * @author shiju.john
 *
 */
@Controller
@CrossOrigin(origins ="*")
public class JobController extends GraphoController<JobDetails> {
	
	@Autowired
	private JobService jobService;
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 */
	@RequestMapping(path="/job",method=RequestMethod.POST)
	public ResponseEntity<JobDetails> addJob (@RequestBody  @Valid JobDetails jobDetails) throws GraphoException{		
		jobDetails = jobService.save(jobDetails);
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);	
	}
	
	/***
	 * 
	 * @return
	 */
	@RequestMapping(path="/job",method=RequestMethod.GET)
	public ResponseEntity<Iterable<JobDetails>> finadAll (){	
		Iterable<JobDetails> jobDetails = jobService.findAll();
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);			
	}
	
	/**
	 * 
	 * @param jobId
	 * @return
	 */
	@RequestMapping(path="/job/{jobId}",method=RequestMethod.GET)
	public ResponseEntity<JobDetails> getJob (@PathVariable("jobId") Long jobId) throws GraphoException{		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setJobId(jobId);		
		jobDetails = jobService.get(jobDetails);
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/job/{jobId}",method=RequestMethod.DELETE)
	public ResponseEntity<JobDetails> deleteJob (@PathVariable("jobId") Long id) throws GraphoException{		
		JobDetails jobDetails = new JobDetails();
		jobDetails.setJobId(id);		
		jobDetails = jobService.delete(jobDetails);
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param jobDetails
	 * @return
	 */
	@RequestMapping(path="/job",method=RequestMethod.PUT)
	public ResponseEntity<JobDetails> updateJob (@RequestBody @Valid JobDetails jobDetails) throws GraphoException{		
		jobDetails = jobService.update(jobDetails); 
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);
			
	}
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping( value = "/job/page",params = { "pageNo", "pageSize","sortField","sortOrder" },method = RequestMethod.GET )
	public ResponseEntity<Pages<JobDetails>> findPage (@RequestParam( "pageNo" ) Integer pageNo, 
			@RequestParam( "pageSize" ) Integer pageSize,@RequestParam("sortField") String sortField,@RequestParam("sortOrder") String sortOrder) throws GraphoException {		
		Pages<JobDetails>  jobDetails = jobService.findPage(pageNo,pageSize,sortField,sortOrder);			
		return new ResponseEntity<>(jobDetails,HttpStatus.OK);		
	}
		
}
