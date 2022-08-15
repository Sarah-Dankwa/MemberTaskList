package com.qa.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.main.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
