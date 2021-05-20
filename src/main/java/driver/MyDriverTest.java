package driver;

import java.sql.*;

public class MyDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("driver.MyDriver");

			// 2. 연결하기
			String url = "jdbc:mydb://127.0.0.1:2202/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. 연결 성공
			System.out.println("ok: " + conn);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
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
