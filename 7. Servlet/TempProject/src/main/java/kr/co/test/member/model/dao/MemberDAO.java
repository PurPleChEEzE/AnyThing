package kr.co.test.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.test.common.DatabaseConnection;
import kr.co.test.member.model.dto.MemberDTO;

public class MemberDAO {
	private Connection con;
	private DatabaseConnection dc;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
	dc = new DatabaseConnection();
	con = dc.connDB();
	}

	public int register(MemberDTO mdto) {
		String query = "INSERT INTO users VALUES(users_seq.nextval, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(query);
//			username?/userid?/password?/birthdate?/address?
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getId());
			pstmt.setString(3, mdto.getPassword());
			pstmt.setString(4, mdto.getBirthdate());
			pstmt.setString(5, mdto.getAddress());
			
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
