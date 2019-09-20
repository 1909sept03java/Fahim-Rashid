package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;

import util.ConnectionUtil;

public class SuperUserStmtsImpl implements SuperUserStmts{

	@Override
	public void createNewUser(String newUsername, String newPassword) throws SQLException, IOException {
		
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO REGISTERED_USER(USERNAME,USER_PASSWORD) VALUES(?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, newUsername);
			stmt.setString(2, newPassword);
			stmt.executeUpdate();
			System.out.println("New account created for "+newUsername);
			
		}

	}

	@Override
	public void deleteUser(int id) throws SQLException, IOException {
		//boolean sure = false;
		//while(sure)
		try(Connection con = ConnectionUtil.getConnection()){
			String sql2 = "DELETE FROM REGISTERED_USER WHERE USER_ID = ?";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setInt(1, id);
			stmt2.executeUpdate();
			System.out.println("User " + id +" has been deleted");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePassword(String username, String password) throws SQLException, IOException {

		try(Connection con =ConnectionUtil.getConnection()){
			String sql3 = "UPDATE REGISTERED_USER SET USER_PASSWORD = ? WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME =?)"; 
			PreparedStatement stmt3 = con.prepareStatement(sql3);
			stmt3.setString(1, password);
			stmt3.setString(2, username);
			stmt3.executeUpdate();
			System.out.println("Your password has been successfully updated");
	
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
