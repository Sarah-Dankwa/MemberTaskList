package com.qa.main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.main.model.Member;
import com.qa.main.service.MemberService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class MemberControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private MemberService service;

	@Test
	public void addMemberTest() throws Exception {
		Member testMember = new Member("Simon Cowell");
		String testMemberAsJson = this.mapper.writeValueAsString(testMember);

		Mockito.when(this.service.addMember(testMember)).thenReturn(testMember);

//		mvc.perform(post("/home/addMember").content(testMemberAsJson).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isCreated()).andReturn();
//
//	}
	}

	@Test
	public void getAllMembersTest() throws JsonProcessingException {
		Member testMember1 = new Member(1L, "Susie Smith");
		Member testMember2 = new Member(2L, "Paula Smith");
		Member testMember3 = new Member(3L, "Daniel Smith");

		String testMember1AsJson = this.mapper.writeValueAsString(testMember1);
		String testMember2AsJson = this.mapper.writeValueAsString(testMember2);
		String testMember3AsJson = this.mapper.writeValueAsString(testMember3);

		List<Member> records = new ArrayList<>(Arrays.asList(testMember1, testMember2, testMember3));

		Mockito.when(this.service.getAll()).thenReturn(records);

		// mvc.perform(get("/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());

	}

	@Test
	public void getMemberByIdTest() throws JsonProcessingException {
		Member testMember = new Member(1L, "Susie Smith");
		String testMemberAsJson = this.mapper.writeValueAsString(testMember);

		Mockito.when(this.service.getMemberByID(1)).thenReturn(testMember);

	}

}
