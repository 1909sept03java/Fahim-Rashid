package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.beans.RegisteredUser;

public interface UserDAO {

	public RegisteredUser getUser(String username) throws SQLException, IOException;
}
