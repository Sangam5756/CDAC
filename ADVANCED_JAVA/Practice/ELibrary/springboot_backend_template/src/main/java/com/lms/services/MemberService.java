package com.lms.services;

import com.lms.dto.MemberCreateRequest;
import com.lms.entity.Member;

public interface MemberService {
	
	
//	create member 
public Member addMember(MemberCreateRequest member);
}
