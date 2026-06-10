package com.jobportal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class JobRequestDTO {

	@NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Location is required")
    private String location;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;

    @NotNull(message = "Experience is required")
    @Min(value = 0, message = "Experience cannot be negative")
    private Integer experience;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "CompanyName is required")
    private String companyName;
}
