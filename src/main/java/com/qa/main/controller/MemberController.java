package com.qa.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.main.model.Member;
import com.qa.main.service.MemberService;

@RestController
@RequestMapping("/home")
@ResponseBody
@ResponseStatus
@CrossOrigin
public class MemberController {

	private List<Member> member = new ArrayList<>();

	private MemberService service;

	public MemberController(MemberService service) {
		this.service = service;
	}

	@PostMapping("/addMember")
	public ResponseEntity<Member> addMember(@RequestBody Member member) {

		Member newMember = service.addMember(member);

		return new ResponseEntity<Member>(newMember, HttpStatus.CREATED);

	}

	@GetMapping("/getMembers")
	public ResponseEntity<List<Member>> getAll() {

		List<Member> allMembers = service.getAll();

		return new ResponseEntity<List<Member>>(allMembers, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getMember/{id}")
	public ResponseEntity<Member> getMember(@PathVariable("id") long id) {

		Member member = service.getMemberByID(id);

		return new ResponseEntity<Member>(member, HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{memberID}")
	public Member updateMember(@PathParam("memberName") String memberName, @PathParam("memberEmail") String memberEmail,
			@PathParam("memberLocation") String memberLocation, @PathVariable("memberID") Long memberID,
			@RequestBody Member member) {
		return service.updateMember(memberID, member);

	}

	@DeleteMapping("/deleteMember/{id}")
	public ResponseEntity<Boolean> deleteMember(@PathVariable long id) {
		Boolean deletedMember = service.removeMember(id);

		return (deletedMember) ? new ResponseEntity<Boolean>(deletedMember, HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(deletedMember, HttpStatus.NOT_FOUND);

	}

}

//	@GetMapping("/test")
//	public String test() {
//		return "This is not a drill";
//	}
