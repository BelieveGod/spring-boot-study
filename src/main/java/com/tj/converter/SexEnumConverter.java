package com.tj.converter;

import java.util.Arrays;

import javax.persistence.AttributeConverter;

import com.tj.enumerate.Sex;

public class SexEnumConverter implements AttributeConverter<Sex,Integer>{

	@Override
	public Integer convertToDatabaseColumn(Sex attribute) {
		
		return attribute.getCode();
	}

	@Override
	public Sex convertToEntityAttribute(Integer dbData) {
		System.out.println(dbData);
		return Arrays.stream(Sex.values()).filter(elements-> elements.getCode().equals(dbData)).findFirst().orElse(null);
		
	}

}
