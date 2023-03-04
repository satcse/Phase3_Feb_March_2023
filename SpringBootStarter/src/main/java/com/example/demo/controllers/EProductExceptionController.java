package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exceptions.ProductNotFoundException;

@ControllerAdvice
public class EProductExceptionController {
	
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<String> exception(ProductNotFoundException exception)
	{		
		return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
	}

}
