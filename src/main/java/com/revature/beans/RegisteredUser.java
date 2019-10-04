package com.revature.beans;

public class RegisteredUser {

	
	public RegisteredUser() {
	super();
	// TODO Auto-generated constructor stub
}
	
	public RegisteredUser(int userId, String firstname, String lastname, String userName, String password,
			int manager) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.password = password;
		this.manager = manager;
	}
	



		private int userId;
		private String firstname;
		private String lastname;
		private String userName;
		private String password;
		private int manager;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getManager() {
			return manager;
		}
		public void setManager(int manager) {
			this.manager = manager;
		}

		
		
		
		
		
}
