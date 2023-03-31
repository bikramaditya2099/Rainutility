package com.rain.utils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

	@XmlElement
	private int code;
	@XmlElement
	private String message;
	@XmlElement
	private String status;
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
	
	public static Response getResponse(ResponseEnum responseEnum)
	{
		Response response=new Response();
		response.setCode(responseEnum.getCode());
		response.setMessage(responseEnum.getMessage());
		response.setStatus(responseEnum.getStatus());
		
		return response;
	}
	
	
}
