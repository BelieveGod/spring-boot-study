package com.tj.service.impl;

import java.io.IOException;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.tj.entity.Student;
import com.tj.repository.StudentRepository;
import com.tj.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {
	private final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student getStudent() {
		return studentRepository.findById(1L).get();
	}
	
	public Student[] getStudentJson() throws JsonParseException, JsonMappingException, IOException{
		Student student = studentRepository.findById(1L).get();
		// 1. javaBean对象转json字符串
		/** fastjson */
		String json=JSONObject.toJSONString(student);
		/** jackson */
		ObjectMapper mapper = new ObjectMapper();
		String json2=mapper.writeValueAsString(student);
		/** Gson */
		Gson gson = new Gson();
		String json3 = gson.toJson(student);
		log.info(json);
		log.info(json2);
		log.info(json3);
		
		// 2. json字符串转javaBean对象
		String str="{\"name\":\"手鞠\",\"age\":16,\"sex\":\"LADY\"}";
		String str2="{name:'佐助',age:17,sex:'GENTLEMEN'}";
		/** fastjson */
		Student pojo = JSONObject.parseObject(str, Student.class);
		Student pojo4 = JSONObject.parseObject(str2, Student.class);
		/** jackson */
		Student pojo2 = mapper.readValue(str, Student.class);
		Student pojo5 = mapper.readValue(str, Student.class);
		/** Gson */
		Student pojo3 = gson.fromJson(str, Student.class);
		Student pojo6 = gson.fromJson(str2, Student.class);

		Student[] arr=new Student[]{pojo,pojo2,pojo3,pojo4,pojo5,pojo6};
		return arr;
	}

}
