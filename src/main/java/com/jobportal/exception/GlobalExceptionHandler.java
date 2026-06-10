package com.jobportal.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage>handlerResourceNotFoundExeption(ResourceNotFoundException ex){
		
		ErrorMessage error=ErrorMessage.builder()
				.message(ex.getMessage())
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.NOT_FOUND.value())
				.build();
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage>handlerResourceAlreadyExistExeption(ResourceAlreadyExistsException ex){
		
		ErrorMessage error=ErrorMessage.builder()
				.message(ex.getMessage())
				.timestamp(LocalDateTime.now())
				.status(HttpStatus.CONFLICT.value())
				.build();
		
		return new ResponseEntity<>(error,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    return ResponseEntity.badRequest().body(errors);
	}
}
