package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import beans.Department;

public interface DepartmentSalaryDAO {
	 public List<Department> getDepartment() throws SQLException, IOException;

}
