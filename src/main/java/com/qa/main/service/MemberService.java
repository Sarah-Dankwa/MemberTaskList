package com.qa.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.main.model.Member;
import com.qa.main.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceMethods {

	private Member member;

	@Autowired
	private MemberRepository repo;

	public MemberService(MemberRepository repo) {
		this.repo = repo;
	}

	@Override
	public Member addMember(Member member) {
		return repo.save(member);
	}

	@Override
	public List<Member> getAll() {
		return repo.findAll();
	}

	@Override
	public Member getMemberByID(long id) {
		Optional<Member> existing = repo.findById(id);
		return existing.get();
	}

	@Override
	public boolean removeMember(long id) {
		repo.deleteById(id);
		boolean exists = repo.existsById(id);
		return !exists;
	}

	public Member updateMember(Long memberID, Member newMember) {
		Optional<Member> existingOptional = repo.findById(memberID);
		Member existing = existingOptional.get();

		existing.setMemberName(newMember.getMemberName());
		existing.setMemberEmail(newMember.getMemberEmail());
		existing.setMemberLocation(newMember.getMemberLocation());

		return repo.save(existing);
	}

}
