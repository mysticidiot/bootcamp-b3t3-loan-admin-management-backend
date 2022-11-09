package com.b3t3.loanAdminManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.dao.Loan_Card_Master_dao;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;

//Service layer for loan card entity

@Service
public class Loan_Card_Master_service_impl implements Loan_Card_Master_service{
	@Autowired
	Loan_Card_Master_dao dao;
	
	public String addCard(Loan_Card_Master card) throws IdAlreadyExistsException {
		if(dao.existsById(card.getLoan_id())) {
			throw new IdAlreadyExistsException();
		}else {
			dao.save(card);
			return "Card Added Successfully!";
		}
	}
	
	public List<Loan_Card_Master> displayAllCards(){
		return (List<Loan_Card_Master>)dao.findAll();
	}
	
	public String deleteCard(String id) throws IdDoesNotExistException {
		if(!dao.existsById(id))
			throw new IdDoesNotExistException();
		else {
			dao.deleteById(id);
			return "Id " + id + " deleted";
		}
	}

	public String updateCard(Loan_Card_Master update_card) throws IdDoesNotExistException {
		if(!dao.existsById(update_card.getLoan_id()))
			throw new IdDoesNotExistException();
		else {
			dao.save(update_card);
			return "Card updated successfully";
		}
	}
	
	
}
