package com.pack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pack.dao.Response;

@RestControllerAdvice
public class ExceptionHandler { 
	@org.springframework.web.bind.annotation.ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<Response> handleException(UserNotFoundException ex){
		return new ResponseEntity<>(new Response(HttpStatus.NOT_FOUND.value(),ex.getMessage(),null),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler({AuthenticationException.class})
	public ResponseEntity<Response> handleException(AuthenticationException ex){
		return new ResponseEntity<>(new Response(HttpStatus.UNAUTHORIZED.value(),ex.getMessage(),null),HttpStatus.UNAUTHORIZED);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(HeaderNotFoundException.class)
	public ResponseEntity<Response> handleException(HeaderNotFoundException ex){	
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
	public ResponseEntity<Response> handleException(RuntimeException ex){
		return new ResponseEntity<>(new Response(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),null),HttpStatus.BAD_REQUEST);
	}
}
