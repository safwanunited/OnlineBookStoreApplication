package com.revature.bookproject.model;

public class Email {
private String emailId;
private String role;
private int id;
public Email() {
	super();
	// TODO Auto-generated constructor stub
}

public Email(String emailId, String role, int id) {
	super();
	this.emailId = emailId;
	this.role = role;
	this.id = id;
}
public String getEmailId() {
	return emailId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


@Override
public String toString() {
	return "Email [emailId=" + emailId + ", role=" + role + "]";
}


}
