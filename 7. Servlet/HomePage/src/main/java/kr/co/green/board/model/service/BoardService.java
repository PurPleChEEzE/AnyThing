package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.PageInfo;

public interface BoardService {
//	리스트 조회
	public ArrayList<FreeDtoImpl> getList(PageInfo pi, String category, String searchText);
	
//	전체 게시글 수
	public int getListCount(String category, String searchText);
	
//	글등록
	public int enroll(FreeDtoImpl freeDto);
	
//	상세보기
	public FreeDtoImpl getDetail(int boardNo);
	
//	글수정폼
	public FreeDtoImpl getEditForm(int boardNo);
	
//	글수정
	public int setEdit(FreeDtoImpl freeDto);
	
//	글삭제
	public int setDelete(int boardNo);
	
//	게시글 번호 검색
	public FreeDtoImpl selectNo(FreeDtoImpl freeDto);

//	파일 정보 등록
	public int fileUpload(FreeDtoImpl freeDto);

//	파일 이름 가져오기
	void getFileName(FreeDtoImpl result);

	int setFileDelete(int fileNo);
}








