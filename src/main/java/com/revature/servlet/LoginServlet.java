package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.RegisteredUser;
import com.revature.beans.Reimbursement;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;


public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		req.getRequestDispatcher("LoginPage.html").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
//		res.sendRedirect("profile");
		LoginDAO log = new LoginDAOImpl();
		UserDAO u = new UserDAOImpl();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		HttpSession session = req.getSession();
//		
			try {
				if(log.credentialCheck(username, password)==1) {
					
					
				
				RegisteredUser currentUser=u.getUser(username);
				
				session.setAttribute("userId", currentUser.getUserId());
				session.setAttribute("userName", currentUser.getUserName());
				session.setAttribute("password", currentUser.getPassword());
				session.setAttribute("manager", currentUser.getManager());
				session.setAttribute("firstName", currentUser.getFirstname());
				session.setAttribute("lastName", currentUser.getLastname());
				
				
//				Reimbursement userReimbursement=rb.seeRequest(username);
//				session.setAttribute("requestId", userReimbursement.getRequestId());
//				session.setAttribute("amount", userReimbursement.getAmount());
//				session.setAttribute("userId", userReimbursement.getUserId());
//				session.setAttribute("status", userReimbursement.getStatus());
				
					
				res.sendRedirect("profile");

					//res.sendRedirect("profile");
				}else if(log.credentialCheck(username, password)==2){
				
					RegisteredUser currentUser=u.getUser(username);
					
					session.setAttribute("userId", currentUser.getUserId());
					session.setAttribute("userName", currentUser.getUserName());
					session.setAttribute("password", currentUser.getPassword());
					session.setAttribute("manager", currentUser.getManager());
					session.setAttribute("firstName", currentUser.getFirstname());
					session.setAttribute("lastName", currentUser.getLastname());
					
					res.sendRedirect("manager");

					
					
					

				}else {
					res.sendRedirect("login");
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	
	}
}