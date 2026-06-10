package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.CompanyRequestDTO;
import com.jobportal.dto.CompanyResponseDTO;

public interface CompanyService {

	  CompanyResponseDTO createCompany(CompanyRequestDTO companyRequestDTO);
	  
	  List<CompanyResponseDTO>getAllCompanies();
	  CompanyResponseDTO getCompanyByEmail(String email);
	  
	  CompanyResponseDTO updateCompany(String email,CompanyRequestDTO companyRequestDTO);
     
	  void deleteCompany(String email);
}
