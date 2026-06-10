package com.jobportal.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

	private String message;
	private int status;
	private LocalDateTime timestamp;
}
