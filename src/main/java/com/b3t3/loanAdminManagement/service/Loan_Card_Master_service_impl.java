package com.b3t3.loanAdminManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.b3t3.loanAdminManagement.dao.Loan_Card_Master_dao;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;

@Service
public class Loan_Card_Master_service_impl implements Loan_Card_Master_service{
	@Autowired
	Loan_Card_Master_dao dao;
	
	public String addCard(Loan_Card_Master card) {
		if(dao.existsById(card.getLoan_id())) {
			return "Card Already Present";
		}else {
			dao.save(card).toString();
			return "Card Added Successfully!";
		}
	}
	
	public List<Loan_Card_Master> displayAllCards(){
		return (List<Loan_Card_Master>)dao.findAll();
	}
	
	public String deleteCard(String id) {
		dao.deleteById(id);
		return "Id " + id + " deleted";
	}

	public String updateCard(Loan_Card_Master update_card) {
		dao.save(update_card);
		return "Card updated successfully";
	}
	
	
}
