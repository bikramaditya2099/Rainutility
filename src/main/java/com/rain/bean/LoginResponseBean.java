package com.rain.bean;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*{
	  "code": 3000,
	  "message": "SUCCESFULL LOGIN",
	  "value": {
	    "firstName": "Amlan",
	    "lastName": "Mishra",
	    "gender": "male",
	    "dob": "30-00-1990",
	    "email": "amlan.you@gmail.com",
	    "phone": 8553368030,
	    "sso": "Vuiu92bfwC4RM4HhwTkwvEw18rCEGHm7fcupehhxwcrxWDPHJ8gj0HtnuXHUTLfFWdp6UM50AyrEftKiajtphiM6NOV6pXAf0xgWb9HuZXY=",
	    "role": "ADMIN"
	  },
	  "status": "SUCCESS"
	}*/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginResponseBean {

	@XmlElement(name="code")
	private int code;
	@XmlElement(name="message")
	private String message;
	@XmlElement(name="value")
	private UserResponseBean value;
	@XmlElement(name="status")
	private String status;
	@XmlElement(name="appId")
	private String appId;
	
	
	

	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public UserResponseBean getValue() {
		return value;
	}
	public void setValue(UserResponseBean value) {
		this.value = value;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoginResponseBean [code=" + code + ", message=" + message
				+ ", value=" + value + ", status=" + status + "]";
	}
	
	
}
