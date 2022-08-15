package com.qa.main.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, name = "member_name")
	private String memberName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id", referencedColumnName = "id")
	private Set<Task> tasks;

	@Autowired
	public Member() {

	}

	@Autowired
	public Member(long id, String memberName, Set<Task> tasks) {
		this.id = id;
		this.memberName = memberName;
		this.tasks = tasks;
	}

	@Autowired
	public Member(long id, String memberName) {
		super();
		this.id = id;
		this.memberName = memberName;
	}

	@Autowired
	public Member(String memberName, Set<Task> tasks) {
		super();
		this.memberName = memberName;
		this.tasks = tasks;
	}

	@Autowired
	public Member(String memberName) {
		super();
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberName=" + memberName + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberName, tasks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(memberName, other.memberName) && Objects.equals(tasks, other.tasks);
	}

}
