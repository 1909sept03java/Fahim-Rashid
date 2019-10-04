package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.service.ConnectionService;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursementList = new ArrayList<>();
		try(Connection con = ConnectionService.getConnection()){
			
			String sql="SELECT * FROM REIMBURSEMENT";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int requestId=rs.getInt("REQUEST_ID");
				double amount=rs.getDouble("REQUEST_AMOUNT");
				int userId=rs.getInt("USER_ID");
				String status=rs.getString("REQUEST_STATUS");
				reimbursementList.add(new Reimbursement(requestId,amount,userId,status));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}return reimbursementList;
	}


	@Override
	public List<Reimbursement> seeRequest(String username) throws SQLException, IOException {
		//Reimbursement userReimbursement=new Reimbursement();
		List<Reimbursement> userReimbursements = new ArrayList<>();
		try(Connection con=ConnectionService.getConnection()){
			String sql2="SELECT * FROM REIMBURSEMENT WHERE USER_ID=(SELECT USER_ID FROM REGISTERED_USER WHERE USERNAME=?)";
			PreparedStatement stmt2=con.prepareStatement(sql2);
			stmt2.setString(1,username);
			ResultSet rs2=stmt2.executeQuery();
			while(rs2.next()) {
//				userReimbursement.setRequestId(rs2.getInt("REQUEST_ID"));
//				userReimbursement.setAmount(rs2.getDouble("REQUEST_AMOUNT"));
//				userReimbursement.setUserId(rs2.getInt("USER_ID"));
//				userReimbursement.setStatus(rs2.getString("REQUEST_STATUS"));
				
				

				int requestId=rs2.getInt("REQUEST_ID");
				double amount=rs2.getDouble("REQUEST_AMOUNT");
				int userId=rs2.getInt("USER_ID");
				String status=rs2.getString("REQUEST_STATUS");
				userReimbursements.add(new Reimbursement(requestId,amount,userId, status));
				
			}
		}
		return userReimbursements;
	}


	@Override
	public void createRequest(int amount, int userId) throws SQLException, IOException {
		try(Connection con=ConnectionService.getConnection()){
			String sql3="INSERT INTO REIMBURSEMENT (REQUEST_AMOUNT,USER_ID) VALUES (?,?)";
			PreparedStatement stmt3=con.prepareStatement(sql3);
			stmt3.setInt(1, amount);
			stmt3.setInt(2, userId);
			stmt3.execute();
		}
	}


	@Override
	public void action(int requestId, String action) throws SQLException, IOException {
		try(Connection con=ConnectionService.getConnection()){
			String dec="";
			if(action.equals("Accept")) {
				
				
				
				dec="Approved";
			}else if(action.equals("Reject")) {
				
				
				
				dec="Denied";
			}
			String sql4="UPDATE REIMBURSEMENT SET REQUEST_STATUS=? WHERE REQUEST_ID=?";
			PreparedStatement stmt4=con.prepareStatement(sql4);
			stmt4.setInt(2, requestId);
			stmt4.setString(1, dec);
			stmt4.executeUpdate();
		}
		
	}
	
	
	
	

}
