package com.tj.entity;



import java.io.Serializable;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import com.tj.converter.SexEnumConverter;
import com.tj.enumerate.Sex;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "com.tj.entity.Student", description = "新增学生参数")
@Entity
@Table(name = "student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "姓名")
	@NotEmpty
	private String name;
	@ApiModelProperty(value = "年龄")
	@Range(min = 0, max = 100, message = "age不能大于100小于0")
	private Integer age;
	@ApiModelProperty(value = "性别")
	@Convert(converter=SexEnumConverter.class)
	private Sex sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
}
