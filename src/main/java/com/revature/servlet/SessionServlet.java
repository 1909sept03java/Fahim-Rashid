package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.RegisteredUser;
import com.revature.beans.Reimbursement;

@WebServlet("/session")
public class SessionServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		try {
			int userId=Integer.parseInt(session.getAttribute("userId").toString());
			String userName=session.getAttribute("userName").toString();
			String password=session.getAttribute("password").toString();
			int manager=Integer.parseInt(session.getAttribute("manager").toString());
			String firstName=session.getAttribute("firstName").toString();
			String lastName=session.getAttribute("lastName").toString();
			
			
			RegisteredUser currentUser=new RegisteredUser(userId,firstName,lastName,userName,password,manager);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(currentUser));
			
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
		}
			
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
