package com.b3t3.loanAdminManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.model.Item_Master;
import com.b3t3.loanAdminManagement.service.Items_Master_service_impl;

@RestController
public class LoanAdminController {
	/*--------Test Purposes only-------------
	@Autowired
	Items_Master_service_impl service;
	
	@PostMapping("/addItem")
	public String insertItem1(@RequestBody Item_Master item) {
		return service.addItem(item);
	}*/
	@Autowired
	Items_Master_service_impl service;
	
	@PostMapping("/addItem")
	public String insertItem1(@RequestBody Item_Master item) {
		return service.addItem(item);
	}
}
