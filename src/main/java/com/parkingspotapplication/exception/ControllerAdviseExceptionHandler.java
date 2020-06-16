package com.parkingspotapplication.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdviseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDate.now());
		body.put("status", status.value());

		List<String> FeildErrors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getField())
				.collect(Collectors.toList());

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		body.put("FeildErrors", FeildErrors);
		body.put("errors", errors);

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
		
	
	
	 @ExceptionHandler(ConstraintViolationException.class)
	  public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
	  WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", "does not enter duplicate values");

			return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	    
	    }
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exception,WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", exception.getMessage());

		return new ResponseEntity<>( body,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = SpotRequestNotFoundException.class)
	public ResponseEntity<Object> exception(SpotRequestNotFoundException exception,WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", exception.getMessage());

		return new ResponseEntity<>( body,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = NoFreeSpotsFoundException.class)
	public ResponseEntity<Object> exception(NoFreeSpotsFoundException exception,WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", exception.getMessage());

		return new ResponseEntity<>( body,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = RequestNotProcessedException.class)
	public ResponseEntity<Object> exception( RequestNotProcessedException exception,WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", exception.getMessage());

		return new ResponseEntity<>( body,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = EnrollAlreadyDoneException.class)
	public ResponseEntity<Object> exception( EnrollAlreadyDoneException exception,WebRequest request) {
		 Map<String, Object> body = new LinkedHashMap<>();
			body.put("timestamp", LocalDateTime.now());
			body.put("message", exception.getMessage());

		return new ResponseEntity<>( body,HttpStatus.NOT_FOUND);
	}
	
	
}
