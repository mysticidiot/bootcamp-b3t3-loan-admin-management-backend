package com.b3t3.loanAdminManagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Employee_Master;
import com.b3t3.loanAdminManagement.service.Employee_Master_service;
import com.b3t3.loanAdminManagement.service.Employee_Master_service_impl;

//Spring mvc controller layer for Employee

@CrossOrigin
@RestController
@RequestMapping("/LAMA/employee")
public class EmployeeController {

	@Autowired
	Employee_Master_service employee_service;
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.OK)
	public String addEmployee(@RequestBody @Valid Employee_Master employee) throws IdAlreadyExistsException {
		return employee_service.addEmployee(employee);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/display")
	@ResponseStatus(HttpStatus.OK)	public List<Employee_Master> showEmployee(){
		return (List<Employee_Master>)employee_service.displayAllEmployee();	
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteEmployee(@PathVariable String id) throws IdDoesNotExistException{
		return employee_service.deleteEmployee(id);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/edit")
	@ResponseStatus(HttpStatus.OK)
	public String updateEmployee(@RequestBody @Valid Employee_Master update_employee) throws IdDoesNotExistException {
		return employee_service.updateEmployee(update_employee);
	}
	

}
