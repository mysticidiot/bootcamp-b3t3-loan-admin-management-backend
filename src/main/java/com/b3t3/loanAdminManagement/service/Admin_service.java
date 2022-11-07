package com.b3t3.loanAdminManagement.service;

import java.util.Optional;

import com.b3t3.loanAdminManagement.model.Admin;

public interface Admin_service {
	
	public Optional<Admin> loginUsingUsernamePassword(Admin admin);

}
