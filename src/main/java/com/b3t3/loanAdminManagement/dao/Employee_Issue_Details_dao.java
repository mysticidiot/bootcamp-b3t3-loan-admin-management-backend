package com.b3t3.loanAdminManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3t3.loanAdminManagement.model.Employee_Issue_Details;


@Repository
public interface Employee_Issue_Details_dao extends JpaRepository<Employee_Issue_Details, String>{
}
