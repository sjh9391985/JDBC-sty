package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. Driver Manager 커넥션 얻기
			String url = "jdbc:mysql://192.168.80.114:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			

			// 3. 연결 성공
			System.out.println("OK: " + conn);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 설치 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
