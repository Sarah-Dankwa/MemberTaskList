package com.qa.main.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taskID;

	@Column(nullable = false, length = 100)
	private String description;

	@Column(name = "member_id")
	private long memberID;

	@Autowired
	public Task() {
	}

	@Autowired
	public Task(long taskID, String description, long memberID) {
		this.taskID = taskID;
		this.description = description;
		this.memberID = memberID;
	}

	@Autowired
	public Task(String description, long memberID) {
		this.description = description;
		this.memberID = memberID;
	}

	public long getTaskID() {
		return taskID;
	}

	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMemberID() {
		return memberID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", description=" + description + ", memberID=" + memberID + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, memberID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && memberID == other.memberID;
	}

}
