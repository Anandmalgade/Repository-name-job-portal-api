package com.jobportal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyRequestDTO {

	@NotBlank(message = "Company Name is required")
	private String companyName;
	
	@Email(message = "Invalid Email")
	private String email;
	
	@NotBlank(message = "website is required")
	private String website;
	
}
