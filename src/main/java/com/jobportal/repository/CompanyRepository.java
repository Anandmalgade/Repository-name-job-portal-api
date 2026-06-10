package com.jobportal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jobportal.entity.Company;

public interface CompanyRepository extends MongoRepository<Company,String> {

	boolean existsByEmail(String email);
	Optional<Company> findByEmailIgnoreCase(String email);
	
   Optional<Company>findByCompanyName(String companyName);
}
