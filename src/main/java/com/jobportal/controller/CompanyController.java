package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
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

import com.jobportal.dto.CompanyRequestDTO;
import com.jobportal.dto.CompanyResponseDTO;
import com.jobportal.entity.Company;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.service.CompanyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

	private final CompanyService companyService;
	

	@PostMapping
	public ResponseEntity<CompanyResponseDTO> addCompany(@Valid @RequestBody CompanyRequestDTO companyRequestDTO) {
		CompanyResponseDTO companyResponseDTO = companyService.createCompany(companyRequestDTO);
	
		return new ResponseEntity<CompanyResponseDTO>(companyResponseDTO, HttpStatus.CREATED);
        
	
	}

	@GetMapping
	public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies() {
		List<CompanyResponseDTO>response=companyService.getAllCompanies();
		return new ResponseEntity<List<CompanyResponseDTO>>(response,HttpStatus.OK);
	}
	@GetMapping("/{email}")
	public ResponseEntity<CompanyResponseDTO>getCompanyById(@PathVariable String email){
		
		CompanyResponseDTO responseDTO=companyService.getCompanyByEmail(email);
		
		return new ResponseEntity<CompanyResponseDTO>(responseDTO,HttpStatus.OK);
	}
	 @DeleteMapping("/{email}")
	public ResponseEntity<?>deleteCompanyById(@PathVariable String email){
		companyService.deleteCompany(email);
		String msg="comapany deleted successfully with email"+email;
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	 @PutMapping("/{email}")
	public ResponseEntity<CompanyResponseDTO>updateCompany(@PathVariable String email,@Valid @RequestBody CompanyRequestDTO companyRequestDTO){
		
		CompanyResponseDTO responseDTO=companyService.updateCompany(email, companyRequestDTO);
		
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
}
