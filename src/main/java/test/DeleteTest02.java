package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest02 {
	public static void main(String[] args) {
		Boolean result = delete(4L);

		System.out.println(result ? "성공!" : "실패");
	}

	public static boolean delete(Long no) {

		// TODO Auto-generated method stub
		Connection conn = null;
		boolean result = false;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. Driver Manager 커넥션 얻기
			String url = "jdbc:mysql://192.168.80.114:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. SQL 문 실행
			String sql = "delete" + " from dept" + " where no= ?" ;
			pstmt = conn.prepareStatement(sql);
				
			// 4. 바인딩
			pstmt.setLong(1, no);

			
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 설치 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				// 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
}
