package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;


@WebServlet("/reimbursement")
public class ReimbursementSessionServlet extends HttpServlet{
	
	ReimbursementDAO rb=new ReimbursementDAOImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession(false);
		try {
			
			//Reimbursement userReimbursement=rb.seeRequest(session.getAttribute("userName").toString());
			List<Reimbursement> reimbursements=rb.seeRequest(session.getAttribute("userName").toString());
			System.out.println(reimbursements.toString());
			
			//int requestId=Integer.parseInt(session.getAttribute("requestId").toString());
//			double amount=Double.valueOf((session.getAttribute("amount").toString()));
//			int userId=Integer.parseInt(session.getAttribute("userId").toString());
//			String status=session.getAttribute("status").toString();
			
//			Reimbursement reimbursement=new Reimbursement(amount,userId,status);
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(reimbursements));
		}catch(Exception e){
			e.printStackTrace();
			
		}
			

	}
	
	
}
