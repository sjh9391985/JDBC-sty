package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest01 {

	public static void main(String[] args) {
		Boolean result = delete(2L);
	}

	public static boolean delete(Long no) {

		Connection conn = null;
		Statement stmt = null;
		boolean result = false;

		try {
			// 1. 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. Connection 객체 연결
			String url = "jdbc:mysql://192.168.80.131:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. stmt 생성
			stmt = conn.createStatement();

			// 4. SQL문 생성
			String sql = "delete" + "  from dept" + " where no = " + no;

			int count = stmt.executeUpdate(sql);
			result = count == 1;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if (stmt != null) {
					stmt.close();
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
