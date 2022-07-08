package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Menu;

public class MenuDaoImpl implements MenuDao{
	
	private static String dburl = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "root";
	private static String dbpasswd = "1234";
	
	@Override
	public void insert(Menu menu) {
		Connection conn =null; 			//연결을 맺어낼 객체
		PreparedStatement ps = null;	//명령을 선언할 객체
		ResultSet rs = null; 			//결과값을 담아낼 객체
		
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "INSERT INTO `tb_menu` (`menu`, `price`, `img`) VALUES (?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getMenu());
			ps.setInt(2, menu.getPrice());
			ps.setString(3, menu.getImg());
			
			int result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("데이터 삽입 성공");
			}
			else {
				System.out.println("데이터 삽입 실패");
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
		}//연결한 부분 닫아주기 finally는 반드시 수행되다.
		
		//ex) ps에서 수행하다 예외 발생시
		//rs는 null인 상태일 때 rs. 수행되면  
		//nullpointerexception이 수행되기 때문에 예외처리
		
	}
	@Override
	public Menu select() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Menu> selectAll() {
		Connection conn =null; 			//연결을 맺어낼 객체
		PreparedStatement ps = null;	//명령을 선언할 객체
		ResultSet rs = null; 			//결과값을 담아낼 객체
		List<Menu> list = new ArrayList<>();//메소드 밖으로 전달할 리스트 (메뉴/dto 를 담은)
		
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			
			String sql = "SELECT * FROM `tb_menu`";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Menu dto = new Menu();
				dto.setMenu(rs.getString("menu"));
				dto.setPrice(rs.getInt("price"));
				dto.setImg(rs.getString("img"));
				
				// 데이터 세팅(set)이 끝나면 리스트에 담는다
				list.add(dto);
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
		return list;
	}
	
	@Override
	public Menu randomSelect() {
		Connection conn = null;		//db 연결
		PreparedStatement pstmt = null;		//쿼리 생성
		ResultSet rs = null;		//select 이후 나오는 결과값
		Menu dto = new Menu();
		
		String sql = "SELECT * FROM tb_menu ORDER BY RAND() LIMIT 1";
		try {
			//드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//커넥션 객체
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
		    
		    if (conn != null) {
		        System.out.println("DB 접속 성공");
		        pstmt = conn.prepareStatement(sql);
		        rs = pstmt.executeQuery();
		        
		        while (rs.next()) {
		            dto.setMenu(rs.getString("menu"));
		            dto.setPrice(rs.getInt("price"));
		            dto.setImg(rs.getString("img"));
		        }
		    }
		} catch (ClassNotFoundException e) {
		    System.out.println("드라이버 로드 실패");
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println("데이터 삽입 실패");
		    e.printStackTrace();
		} finally {
		    try {
		    	if (rs != null) {
		            rs.close();
		        }
		        if (pstmt != null && !pstmt.isClosed()) {
		            pstmt.close();
		        }
		        if (conn != null && !conn.isClosed()) {
		            conn.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		}
		return dto;
	}
	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
