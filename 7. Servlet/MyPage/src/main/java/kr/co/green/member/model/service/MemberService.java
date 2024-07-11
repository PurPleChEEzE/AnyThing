package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.Member;

public interface MemberService {
	public int register(Member member);
	
	public Member login(Member member);
	
}
