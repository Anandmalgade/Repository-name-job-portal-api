package com.jobportal.dto;

import lombok.Data;
@Data
public class JobResponseDTO {

    private String id;
    private String jobTitle;
    private String location;
    private Double salary;
    private Integer experience;
    private String description;

    private String companyName;
}   