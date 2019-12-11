package com.tj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tj.entity.Student;
import com.tj.enumerate.Sex;

@Configuration
public class AppConfiguration {
	
	@Bean
	public Student student(){
		Student student=new Student();
		student.setAge(11);
		student.setName("小李");
		student.setSex(Sex.GENTLEMEN);
		return student;
	}

}
