package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DBUtil;

public class CustomerDao {
	private static DataSource source = DBUtil.getSource();
	
	public static void insert(CustomerVo cvo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO customer VALUES(?,?,?,?)";
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cvo.getId());
			pstmt.setString(2, cvo.getPassword());
			pstmt.setString(3, cvo.getName());
			pstmt.setString(4, cvo.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	/**
	 * 특정 고객을 Database customer table에서 삭제한다.<br>
	 * 호출 하는 곳으로 부터 삭제할 게시물의 id (PK)를 받아 Database에서 삭제한다..
	 * 
	 * Query : delete
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void delete(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM customer WHERE ID=?";
		try {

			conn = source.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	/**
	 * 특정 고객의 password와 email 정보를 Database customer table에서 갱신한다.<br>
	 * 
	 * Query : update
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void update(CustomerVo cvo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "UPDATE customer SET password = ? , email = ? WHERE id = ?";
		try {
			conn = source.getConnection();

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cvo.getPassword());
			pstmt.setString(2, cvo.getEmail());
			pstmt.setString(3, cvo.getId());

			pstmt.executeQuery();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(conn, pstmt);
		}
	}

	/**
	 * 모든 고객의 정보를 Database customer table에서 검색한다.<br>
	 * 
	 * Query : select
	 * 
	 * 1. Connection 생성 2. PreparedStatement 생성 3. 쿼리 전송 4. close()
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static ArrayList<CustomerVo> getCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CustomerVo> allList = new ArrayList<CustomerVo>();
		String sql = "SELECT * FROM customer";
		try {
			conn = source.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				allList.add(new CustomerVo(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return allList;
	}

}