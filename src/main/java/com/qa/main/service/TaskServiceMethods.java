package com.qa.main.service;

import java.util.List;

import com.qa.main.model.Task;

public interface TaskServiceMethods {

	Task addTask(Task task);

	List<Task> getTasks();

	Task getTaskByID(long memberID);

	List<Task> getTaskbyMemberID(long memberID);

	boolean removeTaskByID(long memberID);

	public Task updateTask(long memberID, Task newTask);
}
