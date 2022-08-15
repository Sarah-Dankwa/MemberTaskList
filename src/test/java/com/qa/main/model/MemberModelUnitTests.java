package com.qa.main.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class MemberModelUnitTests {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Member.class).verify();
	}

	@Test
	public void testMemberToString() {
		Member testMember = new Member(1L, "Rachel");
		String expected = "Member [id=" + testMember.getId() + ", memberName=" + testMember.getMemberName() + "]";
		assertEquals(expected, testMember.toString());

	}

	@Test
	public void testMemberConstructor1() {
		Member testMember = new Member(1L, "Rachel");
		assertEquals(Long.valueOf(1), testMember.getId());
		assertEquals("Rachel", testMember.getMemberName());
	}

	@Test
	public void testMemberConstructorWithTasks() {
	}

}
