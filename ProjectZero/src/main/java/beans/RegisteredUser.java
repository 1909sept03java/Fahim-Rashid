package beans;

public class RegisteredUser {
	
	public RegisteredUser() {
		super();
	}
	
	
	public RegisteredUser(int userId,String userName,String password, int accountId, int superUser) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.accountId = accountId;
		this.superUser = superUser;	
	}
		
	
	private int userId;
	private String userName;
	private String password;
	private int accountId;
	private int superUser;
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getSuperUser() {
		return superUser;
	}
	public void setSuperUser(int superUser) {
		this.superUser = superUser;
	}


	@Override
	public String toString() {
		return "UserId=" + userId + ", UserName=" + userName +" AccountId="
				+ accountId + ", SuperUser=" + superUser+"\n";
	}
	
	
	
	
	
	
	
	
	
	
	

}
