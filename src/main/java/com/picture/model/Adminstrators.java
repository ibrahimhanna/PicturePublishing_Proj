package com.picture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "adminstrators")
public class Adminstrators {

private static final long serialVersionUID = -2343243243242432341L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	

	@Column(name="username")
	private String username;
	

	@Column(name="password")
	private String password;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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

	
	
	
}
