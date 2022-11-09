package com.b3t3.loanAdminManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3t3.loanAdminManagement.model.Employee_Master;

//DAO for entity Employee

@Repository
public interface Employee_Master_dao extends JpaRepository<Employee_Master, String>{
}
