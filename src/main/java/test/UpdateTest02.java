package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest02 {
	public static void main(String[] args) {

	}

	public static Boolean update(DeptVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			// 1. driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. connection 객체 생성
			String url = "jdbc:mysql://192.168.80.114:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. SQL 준비
			String sql = "";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
