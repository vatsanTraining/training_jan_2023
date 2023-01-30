package com.example.demo.utils;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = RuntimeException.class)
	public CustomException handleRunTimeException(Exception ex , WebRequest request) {
		
		return new CustomException(LocalDateTime.now(),
				        ex.getMessage(),
				         request.getDescription(false));
		
	}
}
