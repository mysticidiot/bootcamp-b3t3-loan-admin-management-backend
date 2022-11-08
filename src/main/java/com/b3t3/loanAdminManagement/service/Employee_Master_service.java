package com.b3t3.loanAdminManagement.service;

import java.util.List;

import com.b3t3.loanAdminManagement.model.Employee_Master;

public interface Employee_Master_service {
	
	public String addEmployee(Employee_Master employee);
	
	public List<Employee_Master> displayAllEmployee();
	
	public String deleteEmployee(String id);

	public String updateEmployee(Employee_Master update_employee) ;
}

