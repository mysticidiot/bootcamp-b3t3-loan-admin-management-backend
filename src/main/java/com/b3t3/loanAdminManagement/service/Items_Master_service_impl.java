package com.b3t3.loanAdminManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.b3t3.loanAdminManagement.dao.Item_Master_dao;
import com.b3t3.loanAdminManagement.model.Item_Master;

@Service
public class Items_Master_service_impl implements Items_Master_service {
	@Autowired
	Item_Master_dao dao;
	
	public String addItem(Item_Master item) {
		if(dao.existsById(item.getItem_id())) {
			return "Item Present";
		}else {
			dao.save(item).toString();
			return "Item Added Successfully!";
		}
	}
	
	public List<Item_Master> displayAllItems(){
		return (List<Item_Master>)dao.findAll();
	}
	
	public String deleteItem(String id) {
		dao.deleteById(id);
		return "Id " + id + " deleted";
	}

	public String updateItem(Item_Master update_item) {
		dao.save(update_item);
		return "Item updated successfully";
	}
	
	

	
	/*-------Test purposes only ----------------
	@Autowired
	Item_Master_dao dao;
	
	public String addItem(Item_Master item) {
		dao.save(item);
		return "inserted a row in item_master table";
	}*/

}
