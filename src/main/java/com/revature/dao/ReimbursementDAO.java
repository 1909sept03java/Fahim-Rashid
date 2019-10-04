package com.revature.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> getReimbursements()throws SQLException, IOException;
	public List<Reimbursement> seeRequest(String username) throws SQLException, IOException;
	public void createRequest(int amount, int userId) throws SQLException, IOException;
	public void action(int requestId, String action) throws SQLException, IOException;

}
