package kr.co.green.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 	//getter
@Setter		//setter
@NoArgsConstructor		//기본생성자
@AllArgsConstructor		//모든 변수가 있는 생성자
public class FreeDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardViews;
	private String boardIndate;
	private String boardUpdate;
	private String boardDelete;
	private int memberNo;
	private String memberName;
	
	
	private String category="";
	private String searchText="";

}
