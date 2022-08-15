package com.qa.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.main.model.Member;
import com.qa.main.repository.MemberRepository;

@SpringBootTest
public class MemberServiceUnitTest {

	@Autowired
	private MemberService service;

	@MockBean
	private MemberRepository repo;

	@Test
	public void addMemberServiceTest() {

		Member savedMember = new Member("Susie Smith");
		Member repoMember = new Member(1L, "Susie Smith");

		Mockito.when(this.service.addMember(savedMember)).thenReturn(repoMember);

		assertEquals(repoMember, this.service.addMember(savedMember));

		Mockito.verify(this.repo, Mockito.times(1)).save(savedMember);
	}

	@Test
	public void removeMemberServiceTest() {
		Member repoMember = new Member(1L, "Susie Smith");

		Mockito.when(this.service.removeMember(1L)).thenReturn(false);

	}

	@Test
	public void getAllMembersTest() {
		Member testMember1 = new Member(1L, "Susie Smith");
		Member testMember2 = new Member(2L, "Paula Smith");
		Member testMember3 = new Member(3L, "Daniel Smith");

		List<Member> record = new ArrayList<>();

		Mockito.when(this.service.getAll()).thenReturn(record);

	}

	@Test
	public void getMemberByIdServiceTest() {
		Member repoMember = new Member(1L, "Susie Smith");

		Mockito.when(repo.findById(repoMember.getId())).thenReturn(Optional.of(repoMember));

	}

}
