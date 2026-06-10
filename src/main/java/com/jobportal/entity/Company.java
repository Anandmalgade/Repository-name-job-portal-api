package com.jobportal.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection  = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

	@Id
	private String id;	
	
	@Indexed(unique = true)
	private String companyName;
	
	@Indexed(unique = true)
	private String email;
	
	private String website;
	
	@DBRef
	private List<Job>jobs;
	
}
