package com.rain.utils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.rain.bean.LoginResponseBean;
import com.rain.bean.UserResponseBean;

public class LoginFormatter {


	@SuppressWarnings("unchecked")
	public Map getLoginResponse(LoginResponseBean response)
	{
		Map map=new HashMap();
		map.put("code",response.getCode());
		map.put("message",response.getMessage());
		map.put("status",response.getStatus());
		map.put("values", response.getValue());
		return map;
		
	}
	
	@SuppressWarnings("unchecked")
	public UserResponseBean getUserResponse(LoginResponseBean response)
	{
		if(response.getValue()!=null)
		if(response.getValue().getImg()==null)
			response.getValue().setImg("assets/img/profiles/icon-user-default.png");

		return response.getValue();
		
	}
}
