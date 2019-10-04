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

@WebServlet("/allReimbursements")
public class ManagerReimbursementSessionServlet extends HttpServlet{
	
	ReimbursementDAO rb=new ReimbursementDAOImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession(false);
		try {
			List<Reimbursement> allReimbursements=rb.getReimbursements();
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(allReimbursements));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
