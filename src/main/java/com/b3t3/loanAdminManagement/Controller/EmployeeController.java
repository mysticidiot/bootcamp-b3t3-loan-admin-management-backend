package com.b3t3.loanAdminManagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Employee_Master;
import com.b3t3.loanAdminManagement.service.Employee_Master_service;
import com.b3t3.loanAdminManagement.service.Employee_Master_service_impl;

@RestController
@RequestMapping("/LAMA/employee")
public class EmployeeController {
	/*--------Test Purposes only-------------
	@Autowired
	Items_Master_service_impl service;
	
	@PostMapping("/addItem")
	public String insertItem1(@RequestBody Item_Master item) {
		return service.addItem(item);
	}*/
	
	@Autowired
	Employee_Master_service employee_service;
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody @Valid Employee_Master employee) throws IdAlreadyExistsException {
		return employee_service.addEmployee(employee);
	}
	
	@GetMapping("/display")
	public List<Employee_Master> showEmployee(){
		return (List<Employee_Master>)employee_service.displayAllEmployee();	
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable String id) throws IdDoesNotExistException{
		return employee_service.deleteEmployee(id);
	}
	
	@PostMapping("/edit")
	public String updateEmployee(@RequestBody @Valid Employee_Master update_employee) throws IdDoesNotExistException {
		return employee_service.updateEmployee(update_employee);
	}
	

}
