package com.b3t3.loanAdminManagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Item_Master;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;
import com.b3t3.loanAdminManagement.service.Items_Master_service_impl;
import com.b3t3.loanAdminManagement.service.Loan_Card_Master_service_impl;

@RestController
@CrossOrigin
@RequestMapping("/LAMA/card")
public class CardController {
	
	@Autowired
	Loan_Card_Master_service_impl card_service;
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.OK)
	public String addCard(@RequestBody @Valid Loan_Card_Master card) throws IdAlreadyExistsException,MethodArgumentNotValidException {
		return card_service.addCard(card);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/display")
	@ResponseStatus(HttpStatus.OK)
	public List<Loan_Card_Master> showCards(){
		return (List<Loan_Card_Master>)card_service.displayAllCards();	
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteCard(@PathVariable String id) throws IdDoesNotExistException{
		return card_service.deleteCard(id);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/edit")
	@ResponseStatus(HttpStatus.OK)
	public String updateCard(@RequestBody @Valid Loan_Card_Master update_card) throws IdDoesNotExistException {
		return card_service.updateCard(update_card);
	}
	

}
