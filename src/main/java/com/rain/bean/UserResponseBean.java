package com.rain.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponseBean {

	@XmlElement
	private String firstName;
	@XmlElement
	private String lastName;
	@XmlElement
	private String gender;
	@XmlElement
	private String dob;
	@XmlElement
	private String email;
	@XmlElement
	private Long phone;
	@XmlElement
	private String sso;
	@XmlElement
	private String role;
	@XmlElement(name="img")
	private String img;
	@XmlElement(name="appId")
	private String appId;
	
	
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getSso() {
		return sso;
	}
	public void setSso(String sso) {
		this.sso = sso;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserResponseBean [firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", dob=" + dob + ", email="
				+ email + ", phone=" + phone + ", sso=" + sso + ", role="
				+ role + "]";
	}
	
	
}
