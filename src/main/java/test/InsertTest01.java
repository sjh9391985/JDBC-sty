// INSERT stmt 사용예제

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertDepartment("");
	}

	public static boolean insertDepartment(String name) {
		Connection conn = null;
		Statement stmt = null;
		boolean result = false;
		
		try {

			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. Connection 객체 연결
			String url = "jdbc:mysql://192.168.80.114:3307/employees?charset=utf8";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. statement 생성
			stmt = conn.createStatement();
			
			// 4. SQL 문 실행
			String sql = "";
			
			int count = stmt.executeUpdate(sql);
			result = count ==1;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 자원정리(clean-up)
				if(stmt != null) {
					stmt.close();
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
