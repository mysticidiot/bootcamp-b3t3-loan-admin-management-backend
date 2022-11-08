package com.b3t3.loanAdminManagement.service;

import java.util.List;

import com.b3t3.loanAdminManagement.Exception.IdAlreadyExistsException;
import com.b3t3.loanAdminManagement.Exception.IdDoesNotExistException;
import com.b3t3.loanAdminManagement.model.Item_Master;

public interface Items_Master_service {
	
	public String addItem(Item_Master item) throws IdAlreadyExistsException;
	
	public List<Item_Master> displayAllItems();
	
	public String deleteItem(String id) throws IdDoesNotExistException;

	public String updateItem(Item_Master update_item) throws IdDoesNotExistException ;
}
