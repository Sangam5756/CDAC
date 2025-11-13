package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>  {
			
	public boolean  existsByEmail(String email);
}
