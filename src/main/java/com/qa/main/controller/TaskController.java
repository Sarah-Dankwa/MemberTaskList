package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.main.model.Task;
import com.qa.main.service.TaskService;

public class TaskController {

	private List<Task> task = new ArrayList<>();

	private TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@PostMapping("/addTask")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {

		Task newTask = service.addTask(task);

		return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);

	}

	@GetMapping("/getTasks")
	public ResponseEntity<List<Task>> getTasks() {

		List<Task> allTasks = service.getTasks();

		return new ResponseEntity<List<Task>>(allTasks, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getTask/{taskID}")
	public ResponseEntity<Task> getTask(@PathVariable("taskID") long taskID) {

		Task task = service.getTaskByID(taskID);

		return new ResponseEntity<Task>(task, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getMemberTask/{memberID}")
	public ResponseEntity<List<Task>> getMemberTask(@PathVariable("memberID") long memberID) {

		List<Task> tasks = service.getTaskbyMemberID(memberID);

		return new ResponseEntity<List<Task>>(tasks, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{taskID}")
	public Task updateEmployee(@PathParam("description") String description, @PathParam("memberID") Long memberID,
			@PathVariable("taskID") Long taskID, @RequestBody Task task) {
		return service.updateTask(taskID, task);

	}

	@DeleteMapping("/deleteTask/{taskID}")
	public ResponseEntity<Boolean> deleteTask(@PathVariable long taskID) {

		Boolean deletedTask = service.removeTaskByID(taskID);

		return (deletedTask) ? new ResponseEntity<Boolean>(deletedTask, HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(deletedTask, HttpStatus.NOT_FOUND);
	}

}