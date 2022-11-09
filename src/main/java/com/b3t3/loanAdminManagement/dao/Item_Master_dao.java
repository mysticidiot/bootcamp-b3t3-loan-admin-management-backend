package com.b3t3.loanAdminManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3t3.loanAdminManagement.model.Item_Master;

//DAO for entity Item

@Repository
public interface Item_Master_dao extends JpaRepository<Item_Master, String> {

}
