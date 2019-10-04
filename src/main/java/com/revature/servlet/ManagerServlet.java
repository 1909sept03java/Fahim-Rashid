package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ManagerServlet extends HttpServlet{
	
	ReimbursementDAO rb=new ReimbursementDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("Manager.html").forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		//req.getRequestDispatcher("Manager.html").forward(req, res);
		
		String ans=req.getParameter("choice");
		int i=Integer.parseInt(req.getParameter("requestId"));
		
		System.out.println(ans);
		System.out.println(i);
		
		try {
			rb.action(i, ans);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
