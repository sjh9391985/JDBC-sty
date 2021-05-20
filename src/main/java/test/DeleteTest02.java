package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest02 {
	public static void main(String[] args) {
		delete(1L);	
		}

	public static boolean delete(Long no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			//1. Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
				
			//2. connection 연결
			String url =  "jdbc:mysql://192.168.80.114:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url,"hr","hr");
			
			//3. SQL 준비
			String sql =
					"delete" +
						    "  from dept" + 
							" where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//4. binding
			pstmt.setLong(1, no);
			
			//5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1; 
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}finally {
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
