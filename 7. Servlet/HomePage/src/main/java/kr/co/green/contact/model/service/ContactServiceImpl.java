package kr.co.green.contact.model.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dao.ContactDao;
import kr.co.green.contact.model.dto.ContactDto;

public class ContactServiceImpl implements ContactService {
	ContactDao contactDao;
	
	public ContactServiceImpl() {
		contactDao = new ContactDao();
	}
	
	@Override
	public int enroll(ContactDto contactDto) {
		return contactDao.enroll(contactDto);
	}
	
	@Override
	public int listCount() {
		return contactDao.listCount();
	}
	
	@Override
	public ArrayList<ContactDto> getList(PageInfo pi) {
		return contactDao.getList(pi);
	}
	
	@Override
	public ContactDto getDetail(int contactNo) {
		return contactDao.getDetail(contactNo);
	}
	
	@Override
	public int setAnswer(ContactDto contactDto) {
		// contact_answer 테이블에 insert
		int setAnswerResult = contactDao.setAnswer(contactDto);
		
		if(setAnswerResult == 1) {
			// contact 테이블에 c_answer_status 컬럼을 Y로 업데이트
			return contactDao.setAnswerStatus(contactDto.getNo());
		}
		
		return 0;
	}

	@Override
	public int setDelete(int no, String answerStatus) {
		if(answerStatus.equals("Y")) {
			System.out.println("no : " + no);
			// contact_answer 삭제 -> contact 삭제 (답변이 있을 때)
			int answerResult = contactDao.setDeleteAnswer(no);
			
			if(answerResult == 1) {
				return contactDao.setDeleteContact(no);
			}
		}
		
		// contact 삭제 (답변이 없을 때)
		return contactDao.setDeleteContact(no);
	}

}















