package com.b3t3.loanAdminManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "admin")
public class Admin {
	
	//define fields
	//define constructors
	//define getters/setters
	//define toString
	
	@Id
	@Column
	@NotBlank(message = "Username cannot be blank")
	String username;
	
	@Column
	@NotBlank(message = "Password cannot be blank")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
