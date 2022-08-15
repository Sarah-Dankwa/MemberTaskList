package com.qa.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:Member-schema.sql", "classpath:Member-data.sql" })

@ActiveProfiles("test")
public class MemberControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

//	@Test
//	public void addMemberIntergation() throws Exception {
//		Member testMember = new Member("Damon Dash");
//		String testMemberAsJson = this.mapper.writeValueAsString(testMember);
//
//		mvc.perform(post("/home/addMember").content(testMemberAsJson).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated()).andReturn();
//
//	}

}
