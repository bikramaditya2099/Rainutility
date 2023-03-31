package com.rain.utils;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class RainHttpClient {

	static Properties properties = PropertyUtils.getProperties();

	public static String doGet(String url) {

		try {

			Client client = Client.create();
			client.addFilter(new HTTPBasicAuthFilter(properties
					.getProperty("username"), properties
					.getProperty("password")));

			WebResource webResource = client.resource(url);

			ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);

			return output;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	public static <T> T doPost(String url, Object input,
			Map<String, String> headers, Class<T> type) {
		try {

			Client client = Client.create();
			client.addFilter(new HTTPBasicAuthFilter(properties
					.getProperty("username"), properties
					.getProperty("password")));

			WebResource webResource = client.resource(url);

			WebResource.Builder builder = webResource
					.accept(MediaType.APPLICATION_JSON);
			builder.type(MediaType.APPLICATION_JSON);
			if(headers!=null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
			}

			T output = builder.post(type, input);

			return output;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

}
