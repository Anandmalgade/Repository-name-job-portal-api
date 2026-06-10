package com.jobportal.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.dto.CompanyRequestDTO;
import com.jobportal.dto.CompanyResponseDTO;
import com.jobportal.entity.Company;
import com.jobportal.exception.ResourceAlreadyExistsException;
import com.jobportal.exception.ResourceNotFoundException;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class companyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;
	private final ModelMapper modelMapper;
	
	@Transactional
	@Override
	public CompanyResponseDTO createCompany(CompanyRequestDTO companyRequestDTO) {
		// TODO Auto-generated method stub
	
	  if(companyRepository.existsByEmail(companyRequestDTO.getEmail())) {
		    throw new ResourceAlreadyExistsException("Company already exist with this email");
	  }
	   
	  Company company=convertFromCompanyRequestToCompany(companyRequestDTO);
	  
	  Company savedCompany = companyRepository.save(company);

	  System.out.println("Saved Company = " + savedCompany);

	  return convertToCompanyResponseDTO(savedCompany);
	}

	@Override
	public List<CompanyResponseDTO> getAllCompanies() {
		// TODO Auto-generated method stub
		List<Company>companies=companyRepository.findAll();
		if(companies.isEmpty()) {
			throw new ResourceNotFoundException("No companies found");
		}
		List<CompanyResponseDTO>response=new ArrayList<>();
		for(Company company:companies) {
			 response.add(convertToCompanyResponseDTO(company));
		}
		return response;
	}

	@Override
	public CompanyResponseDTO updateCompany(String email, CompanyRequestDTO companyRequestDTO) {
		// TODO Auto-generated method stub
		Company company =companyRepository.findByEmailIgnoreCase(email)
				  .orElseThrow(()-> new ResourceNotFoundException("Company not found wit this email"));
		company.setCompanyName(companyRequestDTO.getCompanyName());
		companyRepository.save(company);
		return convertToCompanyResponseDTO(company);
	}

	@Override
	public void deleteCompany(String email) {
		// TODO Auto-generated method stub
		Company company =companyRepository.findByEmailIgnoreCase(email)
				  .orElseThrow(()-> new ResourceNotFoundException("Company not found wit this email"));
		companyRepository.delete(company);
	}
	@Override
	public CompanyResponseDTO getCompanyByEmail(String email) {
		// TODO Auto-generated method stub
		  Company company =companyRepository.findByEmailIgnoreCase(email)
				  .orElseThrow(()-> new ResourceNotFoundException("Company not found wit this email"));
		 
		  return convertToCompanyResponseDTO(company);
	}
	
	public CompanyRequestDTO convertToCompanyRequestDTO(Company company) {
		
		return modelMapper.map(company,CompanyRequestDTO.class);
	}
	
	public CompanyResponseDTO convertToCompanyResponseDTO(Company company) {
		 return modelMapper.map(company,CompanyResponseDTO.class);
	}
	
	public Company convertFromCompanyRequestToCompany(CompanyRequestDTO companyRequestDTO) {
		companyRequestDTO.setEmail(companyRequestDTO.getEmail().toLowerCase());
		return modelMapper.map(companyRequestDTO,Company.class);
	}
	public Company convertFromCompanyResponseTOCompany(CompanyResponseDTO companyResponseDTO) {
		return modelMapper.map(companyResponseDTO,Company.class);
	}

	
}
