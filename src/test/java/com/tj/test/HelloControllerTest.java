package com.tj.test;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.tj.Application.class)
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testGetSomethingApi() throws Exception {
		String uri = "/hello";

		// 模拟GET请求
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();// 获取返回结果

		// 打印返回结果
		Assert.assertEquals("", mvcResult.getResponse().getContentAsString());
		
	}
}
