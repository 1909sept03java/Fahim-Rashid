package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import beans.CallabeStatement;
import util.CommectionUtil;

public class CallableStatementDAOImpl implements CallableStatementDAO{

	@Override
	public List<CallabeStatement> getNewAvgSalary() throws SQLException, IOException {
		try(Connection conn = CommectionUtil.getConnection()){
			List<CallabeStatement> cs = new ArrayList<>();
			CallableStatement cstmt = conn.prepareCall("call SP_SP_GIVE_RAISE(?,?,?)");
			cstmt.setInt(1,100);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.execute();

		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
