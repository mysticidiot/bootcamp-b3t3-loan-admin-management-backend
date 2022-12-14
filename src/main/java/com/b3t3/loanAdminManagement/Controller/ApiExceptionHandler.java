package com.b3t3.loanAdminManagement.Controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.b3t3.loanAdminManagement.Exception.ApiError;
import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;

@ControllerAdvice
public class ApiExceptionHandler {
	
	//Exception handling methods
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
		BindingResult br = ex.getBindingResult();
		FieldError fieldError = br.getFieldError();
		Map<String,String> response = new HashMap<>();
		response.put("Exception", fieldError.getDefaultMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseEntity<Object> handleSQLException(SQLException ex){
		Map<String,String> response = new HashMap<>();
		response.put("Exception", ex.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex){
		Map<String,String> response = new HashMap<>();
		response.put("Exception", ex.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(IdAlreadyExistsException.class)
	@ResponseBody
	public ResponseEntity<Object> handleIdAlreadyExistsException(IdAlreadyExistsException ex){
		Map<String,String> response = new HashMap<>();
		response.put("Exception", ex.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(IdDoesNotExistException.class)
	@ResponseBody
	public ResponseEntity<Object> handleIdDoesNotExistsException(IdDoesNotExistException ex){
		Map<String,String> response = new HashMap<>();
		response.put("Exception", ex.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(Exception ex){
		Map<String,String> response = new HashMap<>();
		response.put("Exception", ex.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	
}
