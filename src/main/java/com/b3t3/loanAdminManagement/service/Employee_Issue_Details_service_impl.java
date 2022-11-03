package com.b3t3.loanAdminManagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3t3.loanAdminManagement.dao.Employee_Issue_Details_dao;


public class Employee_Issue_Details_service_impl implements Employee_Issue_Details_service {
	
	@Autowired
	Employee_Issue_Details_dao employeeIssueDetailsDao;

}
