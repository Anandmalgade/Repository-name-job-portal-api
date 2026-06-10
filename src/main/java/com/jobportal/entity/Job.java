package com.jobportal.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

	@Id
	private String id;
	
	private String jobTitle;
	
	private String location;
	
	private Double salary;
	
	private Integer experience;
	
	private String description;
	
	@DBRef
	private Company company;
	
}