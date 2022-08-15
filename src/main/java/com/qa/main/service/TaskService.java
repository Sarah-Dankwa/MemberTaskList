package com.qa.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.model.Task;
import com.qa.main.repository.TaskRepository;

@Service
public class TaskService implements TaskServiceMethods {

	private Task task;

	@Autowired
	private TaskRepository trepo;

	public TaskService(TaskRepository trepo) {
		this.trepo = trepo;
	}

	@Override
	public Task addTask(Task task) {
		return trepo.save(task);
	}

	@Override
	public List<Task> getTasks() {
		return trepo.findAll();
	}

	@Override
	public Task getTaskByID(long memberID) {
		Optional<Task> existing = trepo.findById(memberID);
		return existing.get();
	}

	@Override
	public List<Task> getTaskbyMemberID(long memberID) {
		return trepo.showTaskByMemberIDSQL(memberID);
	}

	@Override
	public boolean removeTaskByID(long memberID) {
		trepo.deleteById(memberID);
		boolean exists = trepo.existsById(memberID);
		return !exists;
	}

	@Override
	public Task updateTask(long memberID, Task newTask) {
		Optional<Task> existingOptional = trepo.findById(memberID);
		Task existing = existingOptional.get();

		existing.setDescription(newTask.getDescription());
		existing.setMemberID(newTask.getMemberID());

		return trepo.save(existing);

	}

}
