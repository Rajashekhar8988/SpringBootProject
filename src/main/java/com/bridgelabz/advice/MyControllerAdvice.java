package com.bridgelabz.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input field is Empty", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleEmptyInput(NoSuchElementException NoSuchElementException){
		return new ResponseEntity<String>("Input field is Empty", HttpStatus.BAD_REQUEST);
	}
	

}
