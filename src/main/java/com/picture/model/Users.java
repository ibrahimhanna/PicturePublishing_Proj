package com.picture.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "users")
public class Users implements Serializable{

	private static final long serialVersionUID = -2343243243242432341L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	
	@Column(name="fullname")
	private String fullname;
	

	@Column(name="email")
	private String email;
	

	@Column(name="password")
	private String password;

	

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	
}
