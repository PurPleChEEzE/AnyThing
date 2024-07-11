package kr.co.green.board.model.dto;

public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardViews;
	private String boardIndate;
	private String boardUpdate;
	private String boardDelete;
	private char boardDeleteStatus;
	private int memberNo; // 회원 번호
	private String memberName; // 회원 이름
	
	private int fileNo;
	private String filePath;
	private String fileName;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardViews() {
		return boardViews;
	}
	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}
	public String getBoardIndate() {
		return boardIndate;
	}
	public void setBoardIndate(String boardIndate) {
		this.boardIndate = boardIndate;
	}
	public String getBoardUpdate() {
		return boardUpdate;
	}
	public void setBoardUpdate(String boardUpdate) {
		this.boardUpdate = boardUpdate;
	}
	public String getBoardDelete() {
		return boardDelete;
	}
	public void setBoardDelete(String boardDelete) {
		this.boardDelete = boardDelete;
	}
	public char getBoardDeleteStatus() {
		return boardDeleteStatus;
	}
	public void setBoardDeleteStatus(char boardDeleteStatus) {
		this.boardDeleteStatus = boardDeleteStatus;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "BoardDto [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardViews=" + boardViews + ", boardIndate=" + boardIndate + ", boardUpdate=" + boardUpdate
				+ ", boardDelete=" + boardDelete + ", boardDeleteStatus=" + boardDeleteStatus + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + "]";
	}
	
	
	
	
}
