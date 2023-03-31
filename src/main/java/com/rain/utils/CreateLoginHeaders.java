package com.rain.utils;

import java.util.HashMap;
import java.util.Map;

import com.rain.bean.LoginBean;

public class CreateLoginHeaders {

	public static Map<String,String> create(LoginBean bean)
	{
		Map<String,String> headers=new HashMap<String, String>();
		headers.put("appId",bean.getAppId());
		return headers;
		
	}
}
