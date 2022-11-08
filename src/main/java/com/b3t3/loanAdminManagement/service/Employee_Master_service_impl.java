package com.b3t3.loanAdminManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.b3t3.loanAdminManagement.dao.Employee_Master_dao;
import com.b3t3.loanAdminManagement.model.Employee_Master;

public class Employee_Master_service_impl implements Employee_Master_service {
	
	@Autowired
	Employee_Master_dao dao;
	
	
	public String addEmployee(Employee_Master employee) {
		if(dao.existsById(employee.getEmployee_id())) {
			return "Employee Already Present";
		}else {
			dao.save(employee).toString();
			return "Employee Added Successfully!";
		}
	}
	
	public List<Employee_Master> displayAllEmployee(){
		return (List<Employee_Master>)dao.findAll();
	}
	
	public String deleteEmployee(String id) {
		dao.deleteById(id);
		return "Id " + id + " deleted";
	}

	public String updateEmployee(Employee_Master update_employee) {
		dao.save(update_employee);
		return "Employee updated successfully";
	}
	

	
	
}
