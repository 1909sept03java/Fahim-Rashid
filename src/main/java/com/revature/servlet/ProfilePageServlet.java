package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;

public class ProfilePageServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("ProfilePage.html").forward(req, res);
	}
	//fix the password and username or change the sql method
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		ReimbursementDAO rd=new ReimbursementDAOImpl();
		HttpSession session = req.getSession();
		
		//String reqAmountStr=req.getParameter("requestAmount");
		//double amount=Double.valueOf(reqAmountStr);
		//double amount=Double.parseDouble(req.getParameter("requestAmount"));
		int amount=Integer.parseInt(req.getParameter("requestAmount"));
		
		System.out.println(amount);
		//System.out.println(session.getAttribute("firstName").toString());
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		System.out.println(userId);
		
		try {
			rd.createRequest(amount, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			
////			rd.createRequest(reqAmount, (int)session.getAttribute("userId"));
//			
//			//Reimbursement rb=new Reimbursement();
//			List<Reimbursement> rb=new ArrayList<Reimbursement>();
//			//rb=rd.seeRequest(session.getAttribute("username").toString());
//		
//			
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}
