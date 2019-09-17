package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Department;
import util.CommectionUtil;

public class DepartmentDAOImpl implements DepartmentSalaryDAO{

	@Override
	public List<Department> getDepartment() throws SQLException, IOException {
		// TODO Auto-generated method stub
		List<Department> d1 = new ArrayList<>();
		try(Connection conn = CommectionUtil.getConnection()){
			String sql = "SELECT *FROM DEPARTMET";
			String sql2 = "SELECT DEPARTMENT_ID,AVG(SALARY) AS AVG FROM EMPLOYEE GROUP BY DEPARTMENT_ID";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			ResultSet rs =  pstmt.executeQuery();
			ResultSet rs2 = pstmt2.executeQuery();
			String departmentName = rs.getString("DEPARTMENT_NAME");
			int departmentId = rs.getInt("DEPARTMENT_ID");
			int avgSalary = rs2.getInt("AVG");
			
			
			
			d1.add(new Department(departmentId, departmentName,avgSalary));

//			String sql2 = "SELECT DEPARTMENT_ID,AVG(SALARY) FROM EMPLOYEE GROUP BY DEPARTMENT_ID";
//			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
//			ResultSet rs2 = pstmt2.executeQuery();
			
			for(int i = 0;i <d1.size();i++) {
				System.out.println(d1.get(i));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
