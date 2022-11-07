package com.b3t3.loanAdminManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3t3.loanAdminManagement.dao.Admin_dao;
import com.b3t3.loanAdminManagement.model.Admin;

@Service
public class Admin_service_impl implements Admin_service{
	
	@Autowired
	private Admin_dao adminRepository;

	@Override
	public Optional<Admin> loginUsingUsernamePassword(Admin admin) {
		// TODO Auto-generated method stub
		String username = admin.getUsername();
		String password = admin.getPassword();
		if(isInvalid(username) || isInvalid(password))
			return Optional.empty();
		Optional<Admin> foundValueForUsername = adminRepository.findById(username);
		if(foundValueForUsername.isEmpty())
			return foundValueForUsername;
		else {
			String foundPassword = foundValueForUsername.get().getPassword();
			if(!foundPassword.equals(password))
				return Optional.empty();
			else
				return foundValueForUsername;
		}
	}
	
	private boolean isInvalid(String testString) {
		return testString == null || testString.length() == 0;
	}

}
