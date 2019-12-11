package com.tj.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tj.entity.Student;
import com.tj.service.StudentService;
import com.tj.util.JsonUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags={"学生接口"})
@Controller
public class HelloController {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	
	@ApiOperation(value = "新增学生")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Student.class) })
	@PostMapping("/student")
	@ResponseBody
	public Student addUser( @Validated @RequestBody Student param) {
		logger.info(param.getName());
	    return studentService.getStudent();
	}
	
	@ApiOperation(value = "查看学生")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Student.class) })
	@GetMapping("/student")
	public String getUser(Model model) throws JsonParseException, JsonMappingException, IOException {
	    model.addAttribute("student", studentService.getStudent());
		return "student";
	}
	
	@RequestMapping("/hello")
	public String toHello(){
		return "/index.html";
	}
	
	
	@RequestMapping("/jsonp")
	@ResponseBody
	public String jsonp(String callback){
		String data="\"this is jsonp data!\"";
		return callback+"("+data+")";
	}
}
