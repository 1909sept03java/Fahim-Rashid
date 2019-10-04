package com.revature.beans;

public class Reimbursement {
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement( int requestId, double amount, int userId, String status) {
		super();
		this.requestId = requestId;
		this.amount = amount;
		this.userId = userId;
		this.status = status;
	}
	private int requestId;
	private double amount;
	private int userId;
	private String status;
	
	
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reimbursement [requestId=" + requestId + ", amount=" + amount + ", userId=" + userId + ", status="
				+ status + "]";
	}
	
	
	
	
	
	

}
