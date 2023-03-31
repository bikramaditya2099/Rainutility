package com.rain.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public enum ResponseEnum {

	INVALID_LOGIN(8001,"PLEASE LOGIN","FAIL"),
	LOGOUT_SUCCESSFULL(8002,"SUCCESFULLY LOGOUT","SUCCESS");
	
	@XmlElement(name="code")
	private int code;
	@XmlElement(name="message")
	private String message;
	@XmlElement(name="status")
	private String status;
	private ResponseEnum(int code, String message, String status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	
	
}
