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
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private long id;

	@Column(nullable = false, name = "member_name")
	private String memberName;

	@Column(nullable = false, name = "member_email")
	private String memberEmail;

	@Column(nullable = false, name = "member_location")
	private String memberLocation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id", referencedColumnName = "id")
	private Set<Task> tasks;

	@Autowired
	public Member() {

	}

	@Autowired
	public Member(long id, String memberName, String memberEmail, String memberLocation, Set<Task> tasks) {
		this.id = id;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberLocation = memberLocation;
		this.tasks = tasks;
	}

	@Autowired
	public Member(long id, String memberName, String memberEmail, String memberLocation) {
		this.id = id;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberLocation = memberLocation;
	}

	@Autowired
	public Member(String memberName, String memberEmail, String memberLocation, Set<Task> tasks) {
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberLocation = memberLocation;
		this.tasks = tasks;
	}

	@Autowired
	public Member(String memberName, String memberEmail, String memberLocation) {
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberLocation = memberLocation;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberLocation="
				+ memberLocation + "]";
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

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberLocation() {
		return memberLocation;
	}

	public void setMemberLocation(String memberLocation) {
		this.memberLocation = memberLocation;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberEmail, memberLocation, memberName, tasks);
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
		return Objects.equals(memberEmail, other.memberEmail) && Objects.equals(memberLocation, other.memberLocation)
				&& Objects.equals(memberName, other.memberName) && Objects.equals(tasks, other.tasks);
	}

}
