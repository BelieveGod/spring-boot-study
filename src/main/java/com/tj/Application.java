package com.tj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.spring4all.swagger.EnableSwagger2Doc;


@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2Doc
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
    }
}
