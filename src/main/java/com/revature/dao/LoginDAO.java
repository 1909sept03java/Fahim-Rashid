package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDAO {
	
	public int credentialCheck(String username, String password) throws SQLException, IOException;

}
