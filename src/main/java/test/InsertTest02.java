package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest02 {
	public static void main(String[] args) {
		insert("");
	}
	
	public static boolean insert(String name) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
		try {
			
			//1. 드라이버 로드
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. connection 객체 얻기
			String url =  "jdbc:mysql://192.168.80.114:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			//3. SQL문 준비
			String sql = "";
			pstmt = conn.prepareStatement(sql);
			
			//4. binding
			pstmt.setString(1, name);
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1;
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 자원정리(clean-up)
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
