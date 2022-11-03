package com.b3t3.loanAdminManagement.service;

import org.springframework.beans.factory.annotation.Autowired;


import com.b3t3.loanAdminManagement.dao.Item_Master_dao;

public class Items_Master_service_impl implements Items_Master_service {
	
	@Autowired
	Item_Master_dao itemsMasterDao;
}
