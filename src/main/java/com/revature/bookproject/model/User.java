package com.revature.bookproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name="phoneNo")
	private long phoneNo;
	@Column(name="doornumber")
	private String doornumber;
	@Column(name="street")
	private String street;
	@Column(name="district")
	private String district;
	@Column(name="pincode")
	private int pincode;
	@Column(name="landmark")
	private String landmark;
	
	
	
	public User(String userName, String password, String email, long phoneNo, String doornumber, String street,
			String district, int pincode, String landmark) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.doornumber = doornumber;
		this.street = street;
		this.district = district;
		this.pincode = pincode;
		this.landmark = landmark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDoornumber() {
		return doornumber;
	}
	public void setDoornumber(String doornumber) {
		this.doornumber = doornumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
}
