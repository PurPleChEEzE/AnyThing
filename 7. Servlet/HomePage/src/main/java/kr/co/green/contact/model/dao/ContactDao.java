package kr.co.green.contact.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.common.PageInfo;
import kr.co.green.contact.model.dto.ContactDto;

public class ContactDao {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public ContactDao() {
		dc = new DatabaseConnection();
		con = dc.connDB();
	}
	
	public int enroll(ContactDto contactDto) {
		String query = "INSERT INTO contact"
				+ "		VALUES (contact_seq.NEXTVAL, "
				+ "				?, "
				+ "				?, "
				+ "				?, "
				+ "				DEFAULT, "
				+ "				DEFAULT, "
				+ "				?)";
		
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contactDto.getName());
			pstmt.setString(2, contactDto.getEmail());
			pstmt.setString(3, contactDto.getMessage());
			pstmt.setInt(4, contactDto.getMemberNo());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int listCount() {
		String query = "SELECT count(*) AS cnt FROM contact";
		
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int result = rs.getInt("CNT");
				return result;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<ContactDto> getList(PageInfo pi) {
		ArrayList<ContactDto> result = new ArrayList<>(); // 반환할 객체 생성
		String query = "SELECT * FROM contact"
				+ "		ORDER BY c_indate DESC"
				+ "		OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pi.getOffset());
			pstmt.setInt(2, pi.getBoardLimit());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("C_NO");
				String name = rs.getString("C_NAME");
				String email = rs.getString("C_EMAIL");
				String indate = rs.getString("C_INDATE");
				String answerStatus = rs.getString("C_ANSWER_STATUS");
				
				ContactDto contactDto = new ContactDto();
				contactDto.setNo(no);
				contactDto.setName(name);
				contactDto.setEmail(email);
				contactDto.setIndate(indate);
				contactDto.setAnswerStatus(answerStatus);
				result.add(contactDto);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ContactDto getDetail(int contactNo) {
		String query = "SELECT * FROM contact"
				+ "		WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, contactNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("C_NO");
				String name = rs.getString("C_NAME");
				String email = rs.getString("C_EMAIL");
				String message = rs.getString("C_MESSAGE");
				String indate = rs.getString("C_INDATE");
				String answerStatus = rs.getString("C_ANSWER_STATUS");
				
				ContactDto result = new ContactDto();
				result.setNo(no);
				result.setName(name);
				result.setEmail(email);
				result.setMessage(message);
				result.setIndate(indate);
				result.setAnswerStatus(answerStatus);
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int setAnswer(ContactDto contactDto) {
		String query = "INSERT INTO contact_answer VALUES(contact_answer_seq.nextval, ?, default, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, contactDto.getAnswerContent());
			pstmt.setInt(2, contactDto.getMemberNo());
			pstmt.setInt(3, contactDto.getNo());
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int setAnswerStatus(int no) {
		String query = "UPDATE contact SET c_answer_status = 'Y'"
				+ "		WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int setDeleteAnswer(int no) {
		String query = "DELETE FROM contact_answer"
				+ "		WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int setDeleteContact(int no) {
		String query = "DELETE FROM contact"
				+ "		WHERE c_no = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}















