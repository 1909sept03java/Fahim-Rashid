package main;

import java.sql.Connection;

import util.CommectionUtil;

public class Driver {
	
	public static void main(String[] args) {	
		
		try {
			Connection conn = CommectionUtil.getConnection();
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
