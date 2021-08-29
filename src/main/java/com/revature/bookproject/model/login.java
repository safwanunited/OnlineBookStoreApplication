package com.revature.bookproject.model;

public class login {
private int id;
private String pswd;
private String role;
public login() {
	super();
	// TODO Auto-generated constructor stub
}
public login(int id, String pswd,String role) {
	super();
	this.id = id;
	this.pswd = pswd;
	this.role=role;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPswd() {
	return pswd;
}
public void setPswd(String pswd) {
	this.pswd = pswd;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "login [id=" + id + ", pswd=" + pswd + ", role=" + role + "]";
}


}
