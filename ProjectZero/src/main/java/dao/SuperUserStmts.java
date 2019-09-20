package dao;

import java.io.IOException;
import java.sql.SQLException;

public interface SuperUserStmts {
	
	public void createNewUser(String newUsername, String newPassword) throws SQLException, IOException;
	
	public void deleteUser(int id) throws SQLException, IOException;
	
	public void updatePassword(String username, String password) throws SQLException, IOException;


}
