package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ReimbursementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		//i dont know what this does
		req.getRequestDispatcher("ProfilePage.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ReimbursementDAO rb=new ReimbursementDAOImpl();
		
		HttpSession session = req.getSession();
		
//		String username=session.getAttribute("userName").toString();
//		
//		double amount=Double.valueOf(req.getParameter("requestAmount"));
		
//		try {
////			Reimbursement userReimbursement=rb.seeRequest(username);
////			
////			
////			session.setAttribute("requestId", userReimbursement.getRequestId());
////			session.setAttribute("amount", userReimbursement.getAmount());
////			session.setAttribute("userId", userReimbursement.getUserId());
////			session.setAttribute("status", userReimbursement.getStatus());
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

	}

}
