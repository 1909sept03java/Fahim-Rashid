package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;
import util.OverdraftException;

public class UserStmtsDAOImpl implements UserStmtsDAO {

	@Override
	public void getAccountWithId(String usrName) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection()){
			String sql = "SELECT BANK_ACCOUNTS.BANK_ACCOUNT_ID, BANK_ACCOUNTS.BALANCE FROM BANK_ACCOUNTS WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usrName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			System.out.println("Account ID: \tBalance\n" + rs.getInt("BANK_ACCOUNT_ID")+"\t\t"+ rs.getDouble("BALANCE"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createAccount(double b, String un) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection()){
			String sql2 = "	INSERT INTO BANK_ACCOUNTS(BALANCE, USER_ID) VALUES(?, (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?))";
			PreparedStatement stmt2 = con.prepareStatement(sql2);
			stmt2.setDouble(1, b);
			stmt2.setString(2, un);
			stmt2.executeQuery();
			System.out.println("You have successfully created an account for " + un);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(String un) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection()){
			String sql3 = "SELECT BALANCE FROM BANK_ACCOUNTS WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
			PreparedStatement stmt2 = con.prepareStatement(sql3);
			stmt2.setString(1, un);
			ResultSet rs = stmt2.executeQuery();
			while(rs.next()) {
				double amount = rs.getDouble("BALANCE");
				if(amount>0) {
					System.out.println("Please withddraw all money from account before deleting");
				}else 
					//if(amount==0) 
					{

					String sql4 = "DELETE FROM BANK_ACCOUNTS WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)"; 
					PreparedStatement stmt4 = con.prepareStatement(sql4);		
					stmt4.setString(1, un);
					stmt4.executeQuery();
					System.out.println("Account has been successfully deleted");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeDeposit(double dep, String username) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection()){
			if(dep>0) {
			String sql5 = "UPDATE BANK_ACCOUNTS SET BALANCE = BALANCE+? WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
			PreparedStatement stmt5 = con.prepareStatement(sql5);
			stmt5.setDouble(1, dep);
			stmt5.setString(2, username);
			stmt5.executeUpdate();
			System.out.println("Deposit complete");
			}else {
				System.out.println("That is not a valid deposit amount");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void makeWithdrawal(double withdrawal, String username) throws SQLException, IOException, OverdraftException {
		double currBalance = 0;
		double newBalance = 0;
		try(Connection con = ConnectionUtil.getConnection()){
			String sql6 = "SELECT BALANCE FROM BANK_ACCOUNTS WHERE USER_ID=(SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
			PreparedStatement stmt6 = con.prepareStatement(sql6);
			stmt6.setString(1, username);
			ResultSet rs =stmt6.executeQuery();
			while(rs.next()) {
				currBalance = rs.getDouble("BALANCE");
				System.out.println("Your current balance is " + currBalance);			
			}try {
			if(withdrawal<=currBalance) {
				String sql7 = "UPDATE BANK_ACCOUNTS SET BALANCE = BALANCE-? WHERE USER_ID = (SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
				PreparedStatement stmt7 = con.prepareStatement(sql7);
				stmt7.setDouble(1, withdrawal);
				stmt7.setString(2, username);
				stmt7.executeUpdate();
				System.out.println("Your withdrawal was successful");
				stmt6.executeQuery();
				
				
				String sql8 = "SELECT BALANCE FROM BANK_ACCOUNTS WHERE USER_ID=(SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME = ?)";
				PreparedStatement stmt8 = con.prepareStatement(sql6);
				stmt8.setString(1, username);
				ResultSet rs2 =stmt8.executeQuery();
				while(rs.next()) {
					currBalance = rs.getDouble("BALANCE");
					System.out.println("Your new balance is " + currBalance);	
				}
				
				
				
				
//				while(rs.next()){
//					newBalance = rs.getDouble("BALANCE");
//					System.out.println("Your new balance is " + newBalance);
//				}
				}else if(withdrawal>currBalance) {
					throw new OverdraftException("Overdraft");}}
				catch(OverdraftException Overdraft) {
					System.out.println(Overdraft.getMessage());	
				}catch(SQLException e) {
					//e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
			}
		}
		
	}

}
