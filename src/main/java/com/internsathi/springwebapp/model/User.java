package com.internsathi.springwebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private String password;
	private String address;
	private String phone;
	private String skills;
	private String role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public User(int id, String fullname, String email, String password, String address, String phone, String skills) {
//		super();
//		this.id = id;
//		this.fullname = fullname;
//		this.email = email;
//		this.password = password;
//		this.address = address;
//		this.phone = phone;
//		this.skills = skills;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", phone=" + phone + ", skills=" + skills + "]";
	}

	public User(int id, String fullname, String email, String password, String address, String phone, String skills,
		String role) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.email = email;
	this.password = password;
	this.address = address;
	this.phone = phone;
	this.skills = skills;
	this.role = role;
}

	public String getRole() {
		return role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
