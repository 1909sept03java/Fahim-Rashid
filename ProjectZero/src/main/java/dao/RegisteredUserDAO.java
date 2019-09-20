package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import beans.RegisteredUser;

public interface RegisteredUserDAO {
	
	public List<RegisteredUser> getRegisteredUsers()throws SQLException, IOException;
	public int getUserWithCred(String username, String password) throws SQLException, IOException;
}
