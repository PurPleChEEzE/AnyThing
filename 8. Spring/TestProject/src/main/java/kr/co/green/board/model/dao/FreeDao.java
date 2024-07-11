package kr.co.green.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.green.board.model.dto.FreeDto;
import kr.co.green.common.paging.PageInfo;

@Repository
public class FreeDao {
	private SqlSessionTemplate sqlSession;

	@Autowired
	public FreeDao(SqlSessionTemplate sqlSession) {
		this.sqlSession= sqlSession;
	}
	
	public List<FreeDto> freeList(PageInfo pi, FreeDto free){
		// 단점 : 성능이 구림 ( 절차가 많아짐) -> 규모가 작을때 주로 사용
		RowBounds rb = new RowBounds(pi.getOffset(), pi.getBoardLimit());
		
		return sqlSession.selectList("freeMapper.freeList", free, rb);
	}

	public int getListCount(FreeDto free) {
		return sqlSession.selectOne("freeMapper.getListCount", free);
	}
	
	public FreeDto getDetail(FreeDto free) {
		return sqlSession.selectOne("freeMapper.getDetail", free);
	}
}
