package com.revature.beans;

public class Credentials {
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Credentials(String username, String password, int id) {
		super();
		this.username = username;
		this.password = password;
		this.id=id;
	}
	private String username;
	private String password;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
