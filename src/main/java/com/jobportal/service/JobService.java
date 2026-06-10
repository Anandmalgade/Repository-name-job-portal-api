package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.JobRequestDTO;
import com.jobportal.dto.JobResponseDTO;

public interface JobService {

	
	  public JobResponseDTO createJob(JobRequestDTO jobRequestDTO);
	  public JobResponseDTO getJobById(String id);
	  public List<JobResponseDTO> getAllJobs();
	  public JobResponseDTO updateJob(String id,JobRequestDTO jobRequestDTO);
	  public void deleteJob(String id);
	  
}
