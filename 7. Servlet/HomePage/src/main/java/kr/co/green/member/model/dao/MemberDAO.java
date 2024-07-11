package kr.co.green.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.common.DatabaseConnection;
import kr.co.green.member.model.dto.Member;

public class MemberDAO {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		dc = new DatabaseConnection();																					
		con = dc.connDB();
	}
	
	public int register(Member member) {
		String query = "INSERT INTO member VALUES(member_seq.nextval,?,?,?,default,default)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserId());
			pstmt.setString(3, member.getUserPwd());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Member login(Member member) {
		String query = "SELECT M_NO, M_NAME, M_TYPE FROM MEMBER"
				+ "		WHERE M_ID = ?"
				+ "		AND M_PWD = ?" ;
		Member result = new Member();
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userNo = rs.getInt("M_NO");
				String userName = rs.getString("M_NAME");
				String userType = rs.getString("M_TYPE");
				
				result.setUserNo(userNo);
				result.setUserName(userName);
				result.setUserType(userType);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	public int duplicateId(String id) {
		String query = "SELECT count(*) AS cnt FROM member"
				+ "		WHERE M_ID = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
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

	public Member getHashPassword(String id) {
		String query = "SELECT m_no, m_name, m_password, m_type FROM member"
				+ "		WHERE m_id = ?";
		System.out.println(id);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("M_NO");
				String name = rs.getString("M_NAME");
				String hashPassword = rs.getString("M_PASSWORD");
				String type = rs.getString("M_TYPE");
				
				Member result = new Member();
				result.setUserNo(no);
				result.setUserName(name);
				result.setUserPwd(hashPassword);
				result.setUserType(type);
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}








