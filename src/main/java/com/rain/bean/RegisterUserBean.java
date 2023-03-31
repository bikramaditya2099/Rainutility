package com.rain.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
//{ dob: "16-10-2019", appName: "sdfgh", mobile: 12345, fname: "sdfg", lname: "asdxfc", username: "asdfg@gmail.com", password: "asdfghb" }
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterUserBean {

	@XmlElement(name="appName")
private String appName;
	@XmlElement(name="mobile")
private String mobile;
	@XmlElement(name="owner")
private String owner;

	@XmlElement(name="userEmail")
private String userEmail;
	@XmlElement(name="password")
private String password;
	@XmlElement(name="firstName")
private String firstName;
	@XmlElement(name="lastName")
private String lastName;
	@XmlElement(name="dob")
private String dob;
	@XmlElement(name="phone")
private String phone;
	@XmlElement(name="gender")
private String gender;
	@XmlElement(name="email")
private String email;
	@XmlElement(name="subscriptionType")
	private String subscriptionType;
	
public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "RegisterUserBean [userEmail=" + userEmail + ", password="
			+ password + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", dob=" + dob + ", phone=" + phone + ", gender=" + gender + "]";
}



}
