package com.tj.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tj.entity.Student;


public interface StudentService {
	public Student getStudent();
	public Student[] getStudentJson() throws JsonParseException, JsonMappingException, IOException;
}
