package kr.co.green.board.model.service;

import java.util.List;

import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;
import kr.co.green.common.paging.Pagination;

public interface BoardService {
	//게시글 조회

	List<FreeDto> freeList(PageInfo pi, FreeDto free);
	int getListCount(FreeDto free);
	FreeDto getDetail(FreeDto free);
}
