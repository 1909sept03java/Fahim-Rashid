package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.service.ConnectionService;



public class LoginDAOImpl implements LoginDAO{

	int status;
	@Override
	public int credentialCheck(String username, String password) throws SQLException, IOException {
		try(Connection con = ConnectionService.getConnection()){	
			
			String sql2 = "SELECT*FROM REGISTERED_USER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setString(1,username);
			stmt2.setString(2, password);
			ResultSet rs2 = stmt2.executeQuery();
			while(rs2.next()) {
			if(username.equals(rs2.getString("USERNAME")) && password.equals(rs2.getString("PASSWORD"))&& rs2.getInt("MANAGER")==1) {
				System.out.println("logged in");
				status = 2;
			}else if(username.equalsIgnoreCase(rs2.getString("USERNAME")) && password.equals(rs2.getString("PASSWORD"))&& rs2.getInt("MANAGER")==0) {
				status=1;
				System.out.println("This username and password combo does not exist");
				System.out.println();
			}else {
				status=0;
			}
			}
		}
		return status;
	}
}

