package onlinebookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onlinebookstore.vo.OrderVo;

public class OrderDao {
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

	public List<OrderVo> findAll() {

		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String SQL = "select number, ordernumber, price, address, num" + " from ordertable";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int number = rs.getInt(1);
				int ordernumber = rs.getInt(2);
				int price = rs.getInt(3);
				String address = rs.getString(4);
				int num = rs.getInt(5);

				OrderVo vo = new OrderVo();
				vo.setNumber(number);
				vo.setOrdernumber(ordernumber);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setNum(num);

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
	
	public List<OrderVo> findAll1() {

		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String SQL = "select number2, number, quantity, title" + " from orderbook";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int number2 = rs.getInt(1);
				int number = rs.getInt(2);
				int quantity = rs.getInt(3);
				String title = rs.getString(4);
				
				OrderVo vo = new OrderVo();
				vo.setNumber(number2);
				vo.setOrdernumber(number);
				vo.setPrice(quantity);
				vo.setTitle(title);

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
