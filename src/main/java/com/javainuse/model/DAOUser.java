package com.javainuse.model;

import javax.annotation.Generated;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class DAOUser {

	
	private long id;
	private String username;
	
	@JsonIgnore
	private String password;

	
	

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DAOUser [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public DAOUser(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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
