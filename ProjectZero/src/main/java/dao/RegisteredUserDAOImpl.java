package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.RegisteredUser;
import main.Driver;
import util.ConnectionUtil;

public class RegisteredUserDAOImpl implements RegisteredUserDAO {

	
	@Override
	public List<RegisteredUser> getRegisteredUsers() throws SQLException, IOException {
		List<RegisteredUser> regUsers = new ArrayList<>();

		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT*FROM REGISTERED_USER";

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int userId = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				int superUser = rs.getInt("SUPERUSER");

				regUsers.add(new RegisteredUser(userId,userName, password, accountId, superUser));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return regUsers;
	}
	
	int log = 2; 
		@Override
		public int getUserWithCred(String username, String password) throws SQLException, IOException {
			try(Connection con = ConnectionUtil.getConnection()){	
				String sql2 = "SELECT*FROM REGISTERED_USER WHERE USERNAME = ? AND USER_PASSWORD = ?";
				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setString(1,username);
				stmt2.setString(2, password);
				ResultSet rs2 = stmt2.executeQuery();
				while(rs2.next()) {
				if(username.equalsIgnoreCase(rs2.getString("USERNAME")) && password.equals(rs2.getString("USER_PASSWORD")) && rs2.getInt("SUPERUSER")==0) {
					log = 0;
				}if(username.equalsIgnoreCase(rs2.getString("USERNAME")) && password.equals(rs2.getString("USER_PASSWORD")) && rs2.getInt("SUPERUSER")==1) {
					log = 1;
				}else if(!username.equalsIgnoreCase(rs2.getString("USERNAME")) || !password.equals(rs2.getString("USER_PASSWORD"))) {
					System.out.println("This username and password combo does not exist");
					System.out.println();
					}
				}
			}
			return log;
		}
	}
