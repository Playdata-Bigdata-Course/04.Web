package dept.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import dept.model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {

	public static ArrayList<DeptDTO> deptAll() throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;

		ArrayList<DeptDTO> datas = null;

		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();

			rset = stmt.executeQuery("select * from dept"); // 멤버 변수로 선언 후 멤버변수 활용

			datas = new ArrayList<>();
			while (rset.next()) {
				datas.add(new DeptDTO(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc")));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}

		return datas;
	}
}
