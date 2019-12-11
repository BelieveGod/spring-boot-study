package com.tj.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UnifiedExceptionController {
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public String handleBindException(HttpServletRequest request, BindException exception) {
		List<FieldError> allErrors = exception.getFieldErrors();
		StringBuilder sb = new StringBuilder();
		for (FieldError errorMessage : allErrors) {
			sb.append(errorMessage.getField()).append(": ").append(errorMessage.getDefaultMessage()).append(", ");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
