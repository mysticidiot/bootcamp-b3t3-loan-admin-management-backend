package com.b3t3.loanAdminManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3t3.loanAdminManagement.model.Loan_Card_Master;

//DAO for entity Loan Card

@Repository
public interface Loan_Card_Master_dao extends JpaRepository<Loan_Card_Master,String> {

}
