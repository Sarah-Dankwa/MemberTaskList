package com.qa.main.service;

import java.util.List;

import com.qa.main.model.Member;

public interface MemberServiceMethods {

	Member addMember(Member member);

	List<Member> getAll();

	Member getMemberByID(long id);

	boolean removeMember(long id);

}
