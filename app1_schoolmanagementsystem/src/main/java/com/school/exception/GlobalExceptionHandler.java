package com.school.exception;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	private ResponseEntity<MyError> userNotFoundExceptionHandler(UserNotFoundException unfe, WebRequest wr){
		MyError error = new MyError(LocalDateTime.now(), unfe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	private ResponseEntity<MyError> noHandlerFoundExecptionHandler( NoHandlerFoundException nhfe, WebRequest wr){
		MyError error = new MyError(LocalDateTime.now(), nhfe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLException.class)
	private ResponseEntity<MyError> sqlExceptionHandler( SQLException sq, WebRequest wr){
		MyError error = new MyError(LocalDateTime.now(), sq.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<MyError> methodArgumentNotValidExceptionHandler( MethodArgumentNotValidException ex, WebRequest wr){
		
		String errorMessages = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", ")); 

				MyError error = new MyError(
				LocalDateTime.now(),
				errorMessages,
				wr.getDescription(false)
				);
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<MyError> anyExeceptionHandler(Exception e, WebRequest wr){
		MyError error = new MyError(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyError>(error, HttpStatus.BAD_REQUEST);
	}

}
