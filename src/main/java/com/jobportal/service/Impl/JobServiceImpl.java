package com.jobportal.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dto.JobRequestDTO;
import com.jobportal.dto.JobResponseDTO;
import com.jobportal.entity.Company;
import com.jobportal.entity.Job;
import com.jobportal.exception.ResourceAlreadyExistsException;
import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.service.JobService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;
	private final CompanyRepository companyRepository;
	private final ModelMapper modelMapper;
	@Override
	public JobResponseDTO createJob(JobRequestDTO jobRequestDTO) {
		// TODO Auto-generated method stub
		String name=jobRequestDTO.getCompanyName();
		Company company=companyRepository.findByCompanyName(jobRequestDTO.getCompanyName())
				.orElseThrow(()->new ResourceNotFoundException("Company Not found with Name"+name));
		
		
		Job job=Job.builder()
				.company(company)
				.description(jobRequestDTO.getDescription())
				.experience(jobRequestDTO.getExperience())
				.jobTitle(jobRequestDTO.getJobTitle())
				.location(jobRequestDTO.getLocation())
				.salary(jobRequestDTO.getSalary())
				.build();
		Job savedJob = jobRepository.save(job);
		return convertJobToJobResponse(savedJob);
	}
	@Override
	public JobResponseDTO getJobById(String id) {
		// TODO Auto-generated method stub
		Job job=jobRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Job not found with id: " + id));
		
		return convertJobToJobResponse(job);
	}
	@Override
	public List<JobResponseDTO> getAllJobs() {
		
		List<Job>jobs=jobRepository.findAll();
		if(jobs.isEmpty())
			throw new ResourceNotFoundException("Job not Found");
		List<JobResponseDTO>dto=new ArrayList<>();
		for(Job job:jobs) {
			dto.add(convertJobToJobResponse(job));
		}
		// TODO Auto-generated method stub
		return dto;
	}
	
	@Override
	public JobResponseDTO updateJob(String id,JobRequestDTO jobRequestDTO) {
		Job job = jobRepository.findById(id)
	            .orElseThrow(() ->
	                    new ResourceNotFoundException("Job not found with id: " + id));

	    // Find company by companyName
	    Company company = companyRepository.findByCompanyName(jobRequestDTO.getCompanyName())
	            .orElseThrow(() ->
	                    new ResourceNotFoundException(
	                            "Company not found with name: " + jobRequestDTO.getCompanyName()));

	    // Update fields
	    job.setJobTitle(jobRequestDTO.getJobTitle());
	    job.setLocation(jobRequestDTO.getLocation());
	    job.setSalary(jobRequestDTO.getSalary());
	    job.setExperience(jobRequestDTO.getExperience());
	    job.setDescription(jobRequestDTO.getDescription());
	    job.setCompany(company);

	    // Save updated job
	    Job updatedJob = jobRepository.save(job);

	    return convertJobToJobResponse(updatedJob);
	}
	
	@Override
	public void deleteJob(String id) {
		// TODO Auto-generated method stub
		Job job=jobRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Job not found with id: " + id));
		jobRepository.delete(job);
	}
	
	public JobResponseDTO convertJobToJobResponse(Job job) {
		
		return modelMapper.map(job,JobResponseDTO.class);
	}
	
	
	
}
