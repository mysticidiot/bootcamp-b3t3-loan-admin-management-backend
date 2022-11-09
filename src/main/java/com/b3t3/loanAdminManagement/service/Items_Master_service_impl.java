package com.b3t3.loanAdminManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.dao.Item_Master_dao;
import com.b3t3.loanAdminManagement.model.Item_Master;

//Service layer for Items entity

@Service
public class Items_Master_service_impl implements Items_Master_service {
	@Autowired
	Item_Master_dao dao;
	
	public String addItem(Item_Master item) throws IdAlreadyExistsException {
		if(dao.existsById(item.getItem_id())) {
			throw new IdAlreadyExistsException();
		}else {
			dao.save(item);
			return "Item Added Successfully!";
		}
	}
	
	public List<Item_Master> displayAllItems(){
		return (List<Item_Master>)dao.findAll();
	}
	
	public String deleteItem(String id) throws IdDoesNotExistException{
		if(!dao.existsById(id))
			throw new IdDoesNotExistException();
		else {
			dao.deleteById(id);
			return "Id " + id + " deleted";
		}
	}

	public String updateItem(Item_Master update_item) throws IdDoesNotExistException{
		if(dao.existsById(update_item.getItem_id())) {
			dao.save(update_item);
			return "Item updated successfully";
		}
		throw new IdDoesNotExistException();
	}
	
	

	
	/*-------Test purposes only ----------------
	@Autowired
	Item_Master_dao dao;
	
	public String addItem(Item_Master item) {
		dao.save(item);
		return "inserted a row in item_master table";
	}*/

}
