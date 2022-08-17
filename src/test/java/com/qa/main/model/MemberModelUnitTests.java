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
		Member testMember = new Member(1L, "Rachel Brown", "rachel@email.com", "Leeds");
		String expected = "Member [id=" + testMember.getId() + ", memberName=" + testMember.getMemberName()
				+ ", memberEmail=" + testMember.getMemberEmail() + ", memberLocation=" + testMember.getMemberLocation()
				+ "]";
		assertEquals(expected, testMember.toString());

	}

	@Test
	public void testMemberConstructor1() {
		Member testMember = new Member(1L, "Rachel Brown", "rachel@email.com", "Leeds");
		assertEquals(Long.valueOf(1), testMember.getId());
		assertEquals("Rachel Brown", testMember.getMemberName());
		assertEquals("rachel@email.com", testMember.getMemberEmail());
		assertEquals("Leeds", testMember.getMemberLocation());
	}

	@Test
	public void testMemberConstructor2() {
		Member testMember = new Member("Rachel Brown", "rachel@email.com", "Leeds");
		assertEquals("Rachel Brown", testMember.getMemberName());
		assertEquals("rachel@email.com", testMember.getMemberEmail());
		assertEquals("Leeds", testMember.getMemberLocation());
	}

	@Test
	public void testMemberConstructorWithTasks() {
	}

}
