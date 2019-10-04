package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;

public class dr {
	
	public static void main(String[] args) throws SQLException, IOException {
		System.out.println("Hello World");
		
		LoginDAO log = new LoginDAOImpl();

		String username="Monica";
		String password="passwor";
		
		System.out.println(log.credentialCheck(username, password));
	}

}
