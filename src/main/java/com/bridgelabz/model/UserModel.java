package com.bridgelabz.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	private String userName;
	private String password;
	private String email;
	private int phoneNumber;
	private String address;
	private String city;
	private int pincode;
	
}
