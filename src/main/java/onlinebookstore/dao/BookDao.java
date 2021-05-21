package onlinebookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import onlinebookstore.vo.BookVo;

public class BookDao {

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

	public List<BookVo> findAll() {

		List<BookVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {	
			conn = getConnection();
			String SQL = "select number, id, title, price"+" from book";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int number = rs.getInt(1);
				int id = rs.getInt(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				
				BookVo vo = new BookVo();
				vo.setNumber(number);
				vo.setId(id);
				vo.setTitle(title);
				vo.setPrice(price);
				
				result.add(vo);
			}
			
		}catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
