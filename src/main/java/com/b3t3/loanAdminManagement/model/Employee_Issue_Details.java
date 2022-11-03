package com.b3t3.loanAdminManagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_issue_details")
public class Employee_Issue_Details {

	@Id
	String issue_id;
	
	@Column
	Date issue_date;
	
	@Column
	Date return_date;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	Item_Master itemMaster;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	Employee_Master employeeMaster;

	public String getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(String issue_id) {
		this.issue_id = issue_id;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public Item_Master getItemMaster() {
		return itemMaster;
	}

	public void setItemMaster(Item_Master itemMaster) {
		this.itemMaster = itemMaster;
	}
	

	public Employee_Master getEmployeeMaster() {
		return employeeMaster;
	}

	public void setEmployeeMaster(Employee_Master employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

	public Employee_Issue_Details(String issue_id, Date issue_date, Date return_date, Item_Master itemMaster) {
		super();
		this.issue_id = issue_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
		this.itemMaster = itemMaster;
	}

	public Employee_Issue_Details(String issue_id, Date issue_date, Date return_date, Item_Master itemMaster,
			Employee_Master employeeMaster) {
		super();
		this.issue_id = issue_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
		this.itemMaster = itemMaster;
		this.employeeMaster = employeeMaster;
	}

	public Employee_Issue_Details(String issue_id, Date issue_date, Date return_date) {
		super();
		this.issue_id = issue_id;
		this.issue_date = issue_date;
		this.return_date = return_date;
	}
	
	
	
}
