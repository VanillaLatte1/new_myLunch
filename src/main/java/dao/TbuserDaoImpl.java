package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.tbUser;

public class TbuserDaoImpl implements TbuserDao {
	
	private static String dburl = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "1234";

	@Override
	public tbUser selectLogin(String userId, String userPw) {
		Connection conn =null; 			//연결을 맺어낼 객체
		PreparedStatement ps = null;	//명령을 선언할 객체
		ResultSet rs = null; 			//결과값을 담아낼 객체
		tbUser dto = null;				// 이 메소드에서의 전달 값
		
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "SELECT * FROM tb_user WHERE userId = ? AND userPw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userPw);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("로그인 성공");
				
				dto = new tbUser();
				dto.setId(rs.getInt("id"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
				dto.setName(rs.getString("name"));
				dto.setRegDate(rs.getString("regDate"));
			}
			else {
				System.out.println("로그인 실패!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps != null) {				
				try {
					ps.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			if(conn != null) {				
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
		}
		return dto;
	}

}
