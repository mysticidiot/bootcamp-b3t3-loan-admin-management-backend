package com.b3t3.loanAdminManagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Item_Master;
import com.b3t3.loanAdminManagement.service.Items_Master_service;
import com.b3t3.loanAdminManagement.service.Items_Master_service_impl;

@RestController
@RequestMapping("/LAMA/item")
public class ItemController {

	@Autowired
	Items_Master_service item_service;
	
	@PostMapping("/add")
	public String addItem(@RequestBody @Valid Item_Master item) throws IdAlreadyExistsException{
		return item_service.addItem(item);
	}
	
	@GetMapping("/display")
	public List<Item_Master> showItems(){
		return (List<Item_Master>)item_service.displayAllItems();	
	}
	
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable String id) throws IdDoesNotExistException{
		return item_service.deleteItem(id);
	}
	
	@PostMapping("/edit")
	public String updateItem(@RequestBody @Valid Item_Master update_item) throws IdDoesNotExistException{
		return item_service.updateItem(update_item);
	}
	

}
