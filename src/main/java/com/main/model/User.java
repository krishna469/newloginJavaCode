package com.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Table(name="users") 
@Entity


public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "id", nullable=false)
	private long id=1020;
	
	@NotEmpty
	@Size(min=2,message="user name atleast two Charactor")
	private String name;
	
	@Email
	@NotEmpty
	@Column(name= "username", nullable=false)
	private String username;
	
	@NotEmpty
	@Size(min=6,message="Password shold have at least 6 charactor")
	private String password;
	private String about;
	
	
	
	public User() {
		
	}
	
	public User(String name, String email, String password, String about) {
		super();
		this.name = name;
		username = email;
		this.password = password;
		this.about = about;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return username;
	}
	public void setEmail(String email) {
		this.username = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	

}
