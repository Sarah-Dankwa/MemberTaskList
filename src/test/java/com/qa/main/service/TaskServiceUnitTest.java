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
import com.qa.main.model.Task;
import com.qa.main.repository.MemberRepository;
import com.qa.main.repository.TaskRepository;

@SpringBootTest
public class TaskServiceUnitTest {

	@Autowired
	private TaskService tservice;

	@MockBean
	private TaskRepository trepo;

	@Autowired
	private MemberService mservice;

	@MockBean
	private MemberRepository repo;

	@Test
	public void addTaskServiceTest() {

		Member newMember = new Member("Susie");
		Member newMemberR = new Member(1L, "Susie");

		Task savedTask = new Task("Do something", 1L);
		Task repoTask = new Task(1L, "Do something", 1L);

		Mockito.when(this.mservice.addMember(newMember)).thenReturn(newMemberR);

		Mockito.when(this.tservice.addTask(savedTask)).thenReturn(repoTask);

		assertEquals(repoTask, this.tservice.addTask(savedTask));

		Mockito.verify(this.trepo, Mockito.times(1)).save(savedTask);
	}

	@Test
	public void removeTaskServiceTest() {

		Member newMember = new Member("Susie");
		Member newMemberR = new Member(1L, "Susie");

		Mockito.when(this.mservice.addMember(newMember)).thenReturn(newMemberR);

		Task repoMember = new Task(1L, "Do something", 1L);

		Mockito.when(this.tservice.removeTaskByID(1L)).thenReturn(false);

	}

	@Test
	public void getAllTasksTest() {
		Task testTask1 = new Task(1L, "Do it", 1L);
		Task testTask2 = new Task(2L, "Do more", 2L);
		Task testTask3 = new Task(3L, "Do the most", 3L);

		List<Task> record = new ArrayList<>();

		Mockito.when(this.tservice.getTasks()).thenReturn(record);

	}

	@Test
	public void getTaskByIdServiceTest() {
		Task repoTask = new Task(1L, "Do something", 1L);

		Mockito.when(trepo.findById(repoTask.getTaskID())).thenReturn(Optional.of(repoTask));

	}

}
