package com.lms.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.lms.custom_exception.LMSException;
import com.lms.dto.MemberCreateRequest;
import com.lms.entity.Member;
import com.lms.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	private final ModelMapper mapper;

	@Override
	public Member addMember(MemberCreateRequest member) {
//		got the data from the request
//		check if user already exist
		boolean isExistEmail = memberRepository.existsByEmail(member.getEmail());

		if (isExistEmail) {
			throw new LMSException("email is already exist");
		}

//		now map the member with entity
		Member newMember = mapper.map(member, Member.class);

		return memberRepository.save(newMember);
	}

}
