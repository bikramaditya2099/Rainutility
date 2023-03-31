package com.rain.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.rain.bean.AllUserResponse;
import com.rain.bean.LoginBean;
import com.rain.bean.LoginResponseBean;
import com.rain.bean.RegisterUserBean;
import com.rain.bean.ResponseBean;
import com.rain.bean.UserResponseBean;
import com.rain.utils.CreateLoginHeaders;
import com.rain.utils.LoginFormatter;
import com.rain.utils.PropertyUtils;
import com.rain.utils.RainHttpClient;
import com.rain.utils.Response;
import com.rain.utils.ResponseEnum;

@Path("/app")
public class LoginController {

	
	Properties properties=PropertyUtils.getProperties();
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object login(@Context HttpServletRequest request,LoginBean bean)
	{
		
		HttpSession session=request.getSession();
		String url=properties.getProperty("rainsrv").concat(properties.getProperty("login"));
		LoginResponseBean response= RainHttpClient.doPost(url, bean,CreateLoginHeaders.create(bean),LoginResponseBean.class);
		if (response.getValue()==null)
		{
			Map<String, String> map=new HashMap<String, String>();
			map.put("code", "101");
			map.put("message", "Invalid Credentials");
			return map;
		}
			
		response.getValue().setAppId(bean.getAppId());
		LoginFormatter formatter=new LoginFormatter();
		session.setAttribute("userInfo", formatter.getUserResponse(response));
		return formatter.getLoginResponse(response);
	}
	
	@Path("/getUserInfo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getUserInfo(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession(true);
		if(session.getAttribute("userInfo")==null)
			return Response.getResponse(ResponseEnum.INVALID_LOGIN);
		
		
		return session.getAttribute("userInfo");
	}
	
	@Path("/logout")
	@GET
	
	public Object logout(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession(true);
		session.invalidate();
		return Response.getResponse(ResponseEnum.LOGOUT_SUCCESSFULL);
		
		
		
	}
	
	@Path("/getAllUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAllUsers(@Context HttpServletRequest request)
	{
		HttpSession session=request.getSession(true);
		if(session.getAttribute("userInfo")==null)
			return Response.getResponse(ResponseEnum.INVALID_LOGIN);

		UserResponseBean bean= (UserResponseBean) session.getAttribute("userInfo");
		String url=properties.getProperty("rainsrv").concat(properties.getProperty("getAllUsers"));
		Map<String, String> map=new HashMap<String, String>();
		map.put("sso", bean.getSso());
		map.put("appId",bean.getAppId());
		AllUserResponse response=RainHttpClient.doPost(url, null, map, AllUserResponse.class);
		return response;
	}
	
	@Path("/registerUser")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object registerUser(@Context HttpServletRequest request,RegisterUserBean bean)
	{
		String subscriptionUrl=properties.getProperty("rainsrv").concat(properties.getProperty("subscribe"));
		String registerUrl=properties.getProperty("rainsrv").concat(properties.getProperty("registerApp"));
		
		ResponseBean subscriptionResponse=RainHttpClient.doPost(subscriptionUrl, bean,null, ResponseBean.class);
		if(subscriptionResponse.getCode()==2000) {
			Map<String, String> map=new HashMap<String, String>();
			map.put("payId",(String) subscriptionResponse.getValue());
			bean.setUserEmail(bean.getEmail());
			bean.setOwner(bean.getFirstName());
			ResponseBean registrationResponse=RainHttpClient.doPost(registerUrl, bean,map, ResponseBean.class);
			return registrationResponse;
		}
		
//		Map<String, String> map=new HashMap<String, String>();
//		map.put("appId",appId);
		return subscriptionResponse;
	}
}
