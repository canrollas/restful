package com.G01.onlineFishAuction.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements IUser{
	@Id
	@Column(name="username")
	String username;
	@Column(name="password")
	String password;
	@Column(name="surname")
	String surname;
	@Column(name="name")
	String name;
	@Column(name="mail")
	String mail;
	@Column(name="adress")
	String adress;
	
	
	public Customer(String username, String surname, String name, String mail, String adress) {
		super();
		this.username = username;
		this.surname = surname;
		this.name = name;
		this.mail = mail;
		this.adress = adress;
	}
	
	public Customer() {
		
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getMail() {
		return mail;
	}

	public String getAdress() {
		return adress;
	}
	
	
	

}
