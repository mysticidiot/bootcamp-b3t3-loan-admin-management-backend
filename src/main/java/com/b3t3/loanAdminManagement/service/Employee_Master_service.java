package com.b3t3.loanAdminManagement.service;

import java.util.List;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Employee_Master;

public interface Employee_Master_service {
	
	public String addEmployee(Employee_Master employee) throws IdAlreadyExistsException;
	
	public List<Employee_Master> displayAllEmployee();
	
	public String deleteEmployee(String id) throws IdDoesNotExistException;

	public String updateEmployee(Employee_Master update_employee) throws IdDoesNotExistException;
}

