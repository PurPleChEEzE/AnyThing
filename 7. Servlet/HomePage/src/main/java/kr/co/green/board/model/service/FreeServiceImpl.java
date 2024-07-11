package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dao.FreeDao;
import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.common.PageInfo;

public class FreeServiceImpl implements BoardService {
	FreeDao freeDao;
	
	public FreeServiceImpl() {
		freeDao = new FreeDao();
	}
	
	@Override
	public ArrayList<FreeDtoImpl> getList(PageInfo pi, String category, String searchText) { 
		return freeDao.getList(pi, category, searchText);
	}
	
	@Override
	public int getListCount(String category, String searchText) {
		return freeDao.getListCount(category, searchText);
	}
	
	@Override
	public int enroll(FreeDtoImpl freeDto) {
		return freeDao.enroll(freeDto);
	}
	
	@Override
	public FreeDtoImpl getDetail(int boardNo) {
		// 게시글 상세보기를 가져오면서 필요한 작업
		// 1. 게시글 정보 조회
		FreeDtoImpl result = freeDao.getDetail(boardNo);
		
		// 2. 작성자 조회
		freeDao.getWriter(result);
		
		// 3. 조회수 1 증가
		int resultView = freeDao.setViews(result.getBoardNo());
		
		if(resultView == 1) {
			return result;
		}
		
		return null;
	}
	
	@Override
	public FreeDtoImpl getEditForm(int boardNo) {
		FreeDtoImpl result = freeDao.getDetail(boardNo);
		freeDao.getWriter(result);
		
		return result;
	}
	
	@Override
	public int setEdit(FreeDtoImpl freeDto) {
		return freeDao.setEdit(freeDto);
	}
	
	@Override
	public int setDelete(int boardNo) {
		return freeDao.setDelete(boardNo);
	}
	
	
	@Override
	public FreeDtoImpl selectNo(FreeDtoImpl freeDto) {
		return freeDao.selectNo(freeDto);
	}

	@Override
	public int fileUpload(FreeDtoImpl freeDto) {
		return freeDao.fileUpload(freeDto);
	}

	@Override
	public void getFileName(FreeDtoImpl result) {
		freeDao.getFileName(result);
	}

	@Override
	public int setFileDelete(int fileNo) {
		return freeDao.setFileDelete(fileNo);
	}
	
}














