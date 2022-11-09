package com.b3t3.loanAdminManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b3t3.loanAdminManagement.model.Admin;

//DAO for entity admin

public interface Admin_dao extends JpaRepository<Admin, String>{

}
