package com.b3t3.loanAdminManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.model.Item_Master;
import com.b3t3.loanAdminManagement.model.Loan_Card_Master;
import com.b3t3.loanAdminManagement.service.Items_Master_service_impl;
import com.b3t3.loanAdminManagement.service.Loan_Card_Master_service_impl;

@RestController
@RequestMapping("/LAMA/card")
public class CardController {
	/*--------Test Purposes only-------------
	@Autowired
	Items_Master_service_impl service;
	
	@PostMapping("/addItem")
	public String insertItem1(@RequestBody Item_Master item) {
		return service.addItem(item);
	}*/
	
	@Autowired
	Loan_Card_Master_service_impl card_service;
	
	@PostMapping("/add")
	public String addCard(@RequestBody Loan_Card_Master card) {
		return card_service.addCard(card);
	}
	
	@GetMapping("/display")
	public List<Loan_Card_Master> showCards(){
		return (List<Loan_Card_Master>)card_service.displayAllCards();	
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCard(@PathVariable String id){
		return card_service.deleteCard(id);
	}
	
	@PostMapping("/edit")
	public String updateCard(@RequestBody Loan_Card_Master update_card) {
		return card_service.updateCard(update_card);
	}
	

}
