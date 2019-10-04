package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.RegisteredUser;
import com.revature.service.ConnectionService;

public class UserDAOImpl implements UserDAO {

	@Override
	public RegisteredUser getUser(String username) throws SQLException, IOException {
		RegisteredUser currentUser=new RegisteredUser();
		try(Connection con=ConnectionService.getConnection()){
			String sql="SELECT*FROM REGISTERED_USER WHERE USERNAME=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,username);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				currentUser.setUserId(rs.getInt("USER_ID"));
				currentUser.setFirstname(rs.getString("FIRSTNAME"));
				currentUser.setLastname(rs.getString("LASTNAME"));					
				currentUser.setUserName(rs.getString("USERNAME"));
				currentUser.setPassword(rs.getString("PASSWORD"));
				currentUser.setManager(rs.getInt("MANAGER"));
				
			}
		}
		return currentUser;
	}

}
