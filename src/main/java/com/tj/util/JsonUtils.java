package com.tj.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper mapper=new ObjectMapper();
	
	public static String toJson(Object o){
		String json=null;
		try {
			json= mapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
		
	}
	
	public static <T> T toBean(String jsonString,Class<T> clazz){
		T bean=null;
		try {
			bean= mapper.readValue(jsonString,clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
}
