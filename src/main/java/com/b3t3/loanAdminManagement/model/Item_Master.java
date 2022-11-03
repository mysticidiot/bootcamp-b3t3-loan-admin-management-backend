package com.b3t3.loanAdminManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item_master")
public class Item_Master {
	
	@Id
	String item_id;
	
	@Column
	String item_description;
	
	@Column
	Character item_status;
	
	@Column
	String item_make;
	
	@Column
	String item_category;
	
	@Column
	Long item_valuation;
	
	@OneToMany(mappedBy = "itemMaster")
	List<Employee_Issue_Details> empIssueDetails;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public Character getItem_status() {
		return item_status;
	}

	public void setItem_status(Character item_status) {
		this.item_status = item_status;
	}

	public String getItem_make() {
		return item_make;
	}

	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public Long getItem_valuation() {
		return item_valuation;
	}

	public void setItem_valuation(Long item_valuation) {
		this.item_valuation = item_valuation;
	}

	public Item_Master(String item_id, String item_description, Character item_status, String item_make,
			String item_category, Long item_valuation) {
		super();
		this.item_id = item_id;
		this.item_description = item_description;
		this.item_status = item_status;
		this.item_make = item_make;
		this.item_category = item_category;
		this.item_valuation = item_valuation;
	}
	
	

}
