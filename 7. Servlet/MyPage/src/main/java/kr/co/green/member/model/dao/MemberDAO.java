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
		String query = "INSERT INTO example_member VALUES(example_member_seq.nextval,?,?,?,?,?,?,default)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, member.getUserName());
			pstmt.setString(5, member.getIdNum());
			pstmt.setString(6, member.getPhoneNum());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Member login(Member member) {
		String query = "SELECT EM_NO, EM_NAME FROM example_member WHERE EM_ID = ? AND EM_PASSWORD = ?";
		
		Member result = new Member();
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int userNo = rs.getInt("EM_NO");
				String userName = rs.getString("EM_NAME");
				
				result.setUserNo(userNo);
				result.setUserName(userName);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
