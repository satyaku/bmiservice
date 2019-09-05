package com.fitness.bmiservice.datatypes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	
	
	private String userName;
	private String name;
	private String dob;
	private String contact;
	private int height;
	private String address;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Member [userName=" + userName + ", name=" + name + ", dob=" + dob + ", contact=" + contact + ", height="
				+ height + ", address=" + address + "]";
	}
	
	

}
