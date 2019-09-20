package dao;

import java.io.IOException;
import java.sql.SQLException;

import util.OverdraftException;

public interface UserStmtsDAO {
	
	public void getAccountWithId(String usrname) throws SQLException, IOException;
	public void createAccount(double b, String un) throws SQLException, IOException;
	public void deleteAccount(String un) throws SQLException, IOException;
	public void makeDeposit(double dep, String username) throws SQLException, IOException;
	public void makeWithdrawal(double withdrawal, String username) throws SQLException, IOException, OverdraftException;

}
