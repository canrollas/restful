package com.G01.onlineFishAuction.entities;

//import javax.persistence.MappedSuperclass;


public class User implements IUser{
	private String username;
	private String password;
	
	

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

}
