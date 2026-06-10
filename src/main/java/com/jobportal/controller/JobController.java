package com.jobportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.dto.JobRequestDTO;
import com.jobportal.dto.JobResponseDTO;
import com.jobportal.service.JobService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/job")
public class JobController {

	private final JobService jobService;
	
	@PostMapping
	public ResponseEntity<JobResponseDTO>createJob(@Valid @RequestBody JobRequestDTO jobRequestDTO){
		JobResponseDTO dto=jobService.createJob(jobRequestDTO);
		return new ResponseEntity<JobResponseDTO>(dto,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<JobResponseDTO>getJobById(@PathVariable String id){
		return ResponseEntity.ok(jobService.getJobById(id));
	}
	@GetMapping
	public ResponseEntity<List<JobResponseDTO>> getAllJobs(){
		
		return ResponseEntity.ok(jobService.getAllJobs());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteJob(@PathVariable String id){
		jobService.deleteJob(id);
		return ResponseEntity.ok("job Deleted successfully");
	}
	@PutMapping("/{id}")
	public ResponseEntity<JobResponseDTO>updateJob(@PathVariable String id,@RequestBody JobRequestDTO jobRequestDTO){
		
		return new ResponseEntity<JobResponseDTO>(jobService.updateJob(id, jobRequestDTO),HttpStatus.OK);
	}
	 
}
