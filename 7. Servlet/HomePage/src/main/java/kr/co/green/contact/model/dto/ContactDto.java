package kr.co.green.contact.model.dto;

public class ContactDto {
	// 문의 번호 = no
	private int no;
	
	// 문의 내용 = message
	private String message;
	// 문의 이름 = name
	private String name;
	
	// 문의 이메일 = email
	private String email;
	// 문의 작성일 = indate
	private String indate;
	// 답변 여부 = answerStatus
	private String answerStatus;
	
	// 답변 번호 = answerNo
	private int answerNo;
	// 답변 내용 = answerContent
	private String answerContent;
	// 답변 작성자 = answerWriter
	private String answerWriter;
	// 답변 작성일 = answerIndate
	private String answerIndate;
	
	// 회원 번호 = memberNo
	private int memberNo;
	
	public ContactDto() {
		super();
	}

	public ContactDto(String name, String email, String message, int memberNo) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
		this.memberNo = memberNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerWriter() {
		return answerWriter;
	}

	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}

	public String getAnswerIndate() {
		return answerIndate;
	}

	public void setAnswerIndate(String answerIndate) {
		this.answerIndate = answerIndate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
}
