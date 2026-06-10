package com.jobportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobportal.entity.Job;

public interface JobRepository extends MongoRepository<Job,String> {

	boolean existsById(String id);
	List<Job> findByJobTitleAndExperience(String jobTitle, Integer experience);
}
