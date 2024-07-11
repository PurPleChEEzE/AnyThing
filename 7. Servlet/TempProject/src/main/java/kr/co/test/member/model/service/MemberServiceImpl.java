package kr.co.test.member.model.service;

import kr.co.test.member.model.dao.MemberDAO;
import kr.co.test.member.model.dto.MemberDTO;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		memberDAO = new MemberDAO();
	}

	@Override
	public int register(MemberDTO mdto) {
		return memberDAO.register(mdto);
	}

}
