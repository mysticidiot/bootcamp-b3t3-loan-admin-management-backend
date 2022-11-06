package com.b3t3.loanAdminManagement.service;

import java.util.List;

import com.b3t3.loanAdminManagement.model.Loan_Card_Master;

public interface Loan_Card_Master_service {
	
	public String addCard(Loan_Card_Master card);
	
	public List<Loan_Card_Master> displayAllCards();
	
	public String deleteCard(String id);

	public String updateCard(Loan_Card_Master update_card) ;
}
