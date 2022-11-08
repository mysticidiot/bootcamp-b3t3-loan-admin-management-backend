package com.b3t3.loanAdminManagement.service;

import java.util.List;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;

public interface Loan_Card_Master_service {
	
	public String addCard(Loan_Card_Master card) throws IdAlreadyExistsException;
	
	public List<Loan_Card_Master> displayAllCards();
	
	public String deleteCard(String id) throws IdDoesNotExistException;

	public String updateCard(Loan_Card_Master update_card) throws IdDoesNotExistException ;
}
