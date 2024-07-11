package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.Member;

public interface MemberService {
	//	회원가입
	public int register(Member member);

	//	로그인
	public Member login(Member member);
	
	// 중복검사
	public int duplicateId(String id);
	
	// 암호화된 패스워드 가져오기
	public Member getHashPassword(String id);
}
