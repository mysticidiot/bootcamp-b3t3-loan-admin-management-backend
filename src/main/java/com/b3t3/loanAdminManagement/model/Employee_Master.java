package com.b3t3.loanAdminManagement.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee_master")
public class Employee_Master {

	@Id
	String employee_id;
	
	@Column
	String employee_name;
	
	@Column
	String designation;
	
	@Column
	String department;
	
	@Column
	Character gender;
	
	@Column
	Date date_of_birth;
	
	@Column
	Date date_of_joining;
	
	@OneToMany(mappedBy ="employeeMaster")
	List<Employee_Issue_Details> employeeIssueDetails;
	

	public String getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public Character getGender() {
		return gender;
	}


	public void setGender(Character gender) {
		this.gender = gender;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public Date getDate_of_joining() {
		return date_of_joining;
	}


	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}


	public List<Employee_Issue_Details> getEmployeeIssueDetails() {
		return employeeIssueDetails;
	}


	public void setEmployeeIssueDetails(List<Employee_Issue_Details> employeeIssueDetails) {
		this.employeeIssueDetails = employeeIssueDetails;
	}


	public Employee_Master(String employee_id, String employee_name, String designation, String department,
			Character gender, Date date_of_birth, Date date_of_joining,
			List<Employee_Issue_Details> employeeIssueDetails) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.designation = designation;
		this.department = department;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
		this.employeeIssueDetails = employeeIssueDetails;
	}


	public Employee_Master(String employee_id, String employee_name, String designation, String department,
			Character gender, Date date_of_birth, Date date_of_joining) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.designation = designation;
		this.department = department;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
	}
	
}
