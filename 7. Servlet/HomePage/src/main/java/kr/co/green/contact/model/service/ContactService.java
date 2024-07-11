package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dto.ContactDto;

public interface ContactService {
//	등록
	public int enroll(ContactDto contactDto);
	
//	전체 게시글 수
	public int listCount();

//	게시글 목록
	public ArrayList<ContactDto> getList(PageInfo pi);
	
//	게시글 정보
	public ContactDto getDetail(int contactNo);
	
//	답변
	public int setAnswer(ContactDto contactDto);
	
//	게시글 삭제
	public int setDelete(int no, String answerStatus);
}
