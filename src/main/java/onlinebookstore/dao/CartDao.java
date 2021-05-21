package onlinebookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onlinebookstore.vo.BookVo;
import onlinebookstore.vo.CartVo;

public class CartDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.80.114:3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		return conn;
	}

	public List<CartVo> findAll() {

		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String SQL = "select number, num, quantity "+"from cart";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int number = rs.getInt(1);
				int num = rs.getInt(2);
				int quantity = rs.getInt(3);

				CartVo vo = new CartVo();
				vo.setNumber(number);
				vo.setNum(num);
				vo.setQuantity(quantity);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
