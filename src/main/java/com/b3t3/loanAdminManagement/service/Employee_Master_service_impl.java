package com.b3t3.loanAdminManagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.b3t3.loanAdminManagement.dao.Employee_Master_dao;

public class Employee_Master_service_impl implements Employee_Master_service {
	
	@Autowired
	Employee_Master_dao employeeMasterDao;

}
