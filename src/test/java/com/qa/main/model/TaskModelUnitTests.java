package com.qa.main.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TaskModelUnitTests {

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Task.class).verify();
	}

	@Test
	public void testTaskToString() {
		Task testTask = new Task(1L, "Get manicure ad pedicure", 1L);
		String expected = "Task [taskID=" + testTask.getTaskID() + ", description=" + testTask.getDescription()
				+ ", memberID=" + testTask.getMemberID() + "]";
		assertEquals(expected, testTask.toString());

	}

	@Test
	public void testTaskConstructor1() {
		Task testTask = new Task(1L, "Get manicure ad pedicure", 1L);
		assertEquals(Long.valueOf(1), testTask.getTaskID());
		assertEquals("Get manicure ad pedicure", testTask.getDescription());
		assertEquals(Long.valueOf(1), testTask.getMemberID());
	}

	@Test
	public void testMemberConstructorWithTasks() {
	}

}
