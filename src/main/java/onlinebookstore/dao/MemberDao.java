package onlinebookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onlinebookstore.vo.MemberVo;

public class MemberDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.114:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}
	
	public List<MemberVo> findAll() {
		List<MemberVo> result = new ArrayList<>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select num, name, email, password, phonenumber" + " from member ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int password = rs.getInt(4);
				int phonenumber = rs.getInt(5);
				
				MemberVo vo = new MemberVo();
				vo.setNum(num);
				vo.setName(name);
				vo.setEmail(email);
				vo.setPassword(password);
				vo.setPhonenumber(phonenumber);
				
				result.add(vo);
				
			}
			
			
		}catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}

}
