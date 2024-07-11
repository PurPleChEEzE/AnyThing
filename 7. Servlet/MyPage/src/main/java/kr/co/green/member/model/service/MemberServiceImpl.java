package kr.co.green.member.model.service;

import kr.co.green.member.model.dao.MemberDAO;
import kr.co.green.member.model.dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		memberDAO = new MemberDAO();
	}
	
	@Override
	public int register(Member member) {
		return memberDAO.register(member);
	}
	
	@Override
	public Member login(Member member) {
		return memberDAO.login(member);
	}
}
