package com.b3t3.loanAdminManagement.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.model.Admin;
import com.b3t3.loanAdminManagement.service.Admin_service;

@RestController
@RequestMapping("/LAMA/login")
public class AdminController {
	
	@Autowired
	private Admin_service adminService;
	
	@CrossOrigin
	@PostMapping(path = "/challenge", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> verifyLogin(@RequestBody @Valid Admin requestBody){
		Optional<Admin> admin =  adminService.loginUsingUsernamePassword(requestBody);
		Map<String,String> response = new HashMap<>();
		if(admin.isEmpty()) {
			response.put("authenticated", "no");
			return new ResponseEntity<Object>(response,HttpStatus.FORBIDDEN);
		}
		else {
			response.put("authenticated", "yes");
			response.put("username", requestBody.getUsername());
			response.put("password", requestBody.getPassword());
			return new ResponseEntity<Object>(response,HttpStatus.OK);
		}
	}

}
