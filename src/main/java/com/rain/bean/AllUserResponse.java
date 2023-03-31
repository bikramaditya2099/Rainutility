package com.rain.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class AllUserResponse {

	@XmlElement
	private int code;
	@XmlElement
	private String message;
	@XmlElement
	private List<UserBean> value;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMesssage() {
		return message;
	}
	public void setMesssage(String messsage) {
		this.message = messsage;
	}
	public List<UserBean> getValue() {
		return value;
	}
	public void setValue(List<UserBean> value) {
		this.value = value;
	}
	
	
}
