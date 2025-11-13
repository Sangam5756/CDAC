package com.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.dto.MemberCreateRequest;
import com.lms.services.MemberService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MemberController {
		
	private final MemberService memberService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewMember(@RequestBody @Valid MemberCreateRequest member){
		return ResponseEntity.ok(memberService.addMember(member));
	}
	
	
}
