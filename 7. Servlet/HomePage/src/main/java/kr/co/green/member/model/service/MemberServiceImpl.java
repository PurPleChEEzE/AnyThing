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
//		return memberDAO.register(member);
		
		int result = memberDAO.register(member);
		return result;
	}
	
	@Override
	public Member login(Member member) {
		return memberDAO.login(member);
	}
	
	@Override
	public int duplicateId(String id) {
		return memberDAO.duplicateId(id);
	}
	
	@Override
	public Member getHashPassword(String id) {
		return memberDAO.getHashPassword(id);
	}
	
}









