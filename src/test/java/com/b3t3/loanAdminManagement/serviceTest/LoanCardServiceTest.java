package com.b3t3.loanAdminManagement.serviceTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.dao.Loan_Card_Master_dao;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;
import com.b3t3.loanAdminManagement.service.Loan_Card_Master_service_impl;

@RunWith(MockitoJUnitRunner.class)
public class LoanCardServiceTest {
	
	//Class to test the loan card service
	
	@Mock
	Loan_Card_Master_dao repository;
	
	@InjectMocks
	Loan_Card_Master_service_impl loanService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	public void addNewLoanCard() throws IdAlreadyExistsException {
		Loan_Card_Master newCard = new Loan_Card_Master("newId", "short", 4);
		when(repository.findById(anyString())).thenReturn(Optional.of(newCard));
		String response = loanService.addCard(newCard);
		assert(response.equals("Card Added Successfully!"));
		Optional<Loan_Card_Master> found = repository.findById(newCard.getLoan_id());
		assert(found.isPresent());
		assert(found.get().getLoan_id().equals(newCard.getLoan_id()));
	}
	
	@Test
	public void updateLoanCard(){
		Loan_Card_Master newCard = new Loan_Card_Master("newId", "short", 4);
		String response;
		when(repository.findById(anyString())).thenReturn(Optional.of(newCard));
		try {	
			newCard.setDuration_in_years(5);
			response = loanService.updateCard(newCard);
			assert(response.toLowerCase().contains("updated"));
		}catch (Exception e) {
			assert(e.getMessage().toLowerCase().contains("does not exist"));
		}
	}
	
	@Test
	public void deleteLoanCard(){
		Loan_Card_Master newCard = new Loan_Card_Master("newId", "short", 4);
		String response;
		when(repository.findById(anyString())).thenReturn(Optional.of(newCard));
		try {	
			response = loanService.deleteCard(newCard.getLoan_id());
			assert(response.toLowerCase().contains("deleted"));
		}catch (Exception e) {
			assert(e.getMessage().toLowerCase().contains("does not exist"));
		}
	}
	
	@Test
	public void deleteCardWhenDoesNotExist(){
		Loan_Card_Master newCard = new Loan_Card_Master("newId", "short", 4);
		when(repository.findById(anyString())).thenReturn(Optional.of(newCard));
		assertThrows(IdDoesNotExistException.class, () -> {
			loanService.deleteCard(newCard.getLoan_id());
		});
	}
	
	@Test
	public void updateCardWhenDoesNotExist(){
		Loan_Card_Master newCard = new Loan_Card_Master("newId", "short", 4);
		when(repository.findById(anyString())).thenReturn(Optional.of(newCard));
		assertThrows(IdDoesNotExistException.class, () -> {
			loanService.updateCard(newCard);
		});
	}
	

}
