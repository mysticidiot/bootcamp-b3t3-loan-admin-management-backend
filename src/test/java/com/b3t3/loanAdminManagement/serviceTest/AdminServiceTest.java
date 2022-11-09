package com.b3t3.loanAdminManagement.serviceTest;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.b3t3.loanAdminManagement.dao.Admin_dao;
import com.b3t3.loanAdminManagement.model.Admin;
import com.b3t3.loanAdminManagement.service.Admin_service;
import com.b3t3.loanAdminManagement.service.Admin_service_impl;

@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest {
	
	@Mock
	Admin_dao adminRepository;
	
	@InjectMocks
	Admin_service_impl adminService;
	

	void SetUpAdminRepoReturnValue(){
		Admin admin = new Admin("123", "123");
		when(adminRepository.findById(anyString())).thenReturn(Optional.of(admin));
	}
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	public void testCorrectLogin() {
		SetUpAdminRepoReturnValue();
		Admin admin = new Admin("123", "123");
		Admin found = adminService.loginUsingUsernamePassword(admin).get();
		assert(found.getUsername().equals("123"));
		assert(found.getPassword().equals("123"));
		
	}
	
	@Test
	public void testIncorrectLogin() {
		SetUpAdminRepoReturnValue();
		Admin admin = new Admin("12345", "");
		Optional<Admin> found = adminService.loginUsingUsernamePassword(admin);
		assert(found.isEmpty());
	}

}
