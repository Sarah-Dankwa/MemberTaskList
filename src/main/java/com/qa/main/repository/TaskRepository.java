package com.qa.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.main.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "SELECT taskID, description, t.member_id, member_name FROM task t INNER JOIN members m ON t.member_id = m.id WHERE member_id = ?1", nativeQuery = true)
	List<Task> showTaskByMemberIDSQL(long memberID);

}
