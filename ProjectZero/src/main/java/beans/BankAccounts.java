package beans;


public class BankAccounts {
	
	public BankAccounts() {
		super();
	}
	
	public BankAccounts(int accountId, double balance, int userId) {
		super();
		this.accountId =accountId;
		this.balance = balance;
		this.userId = userId;
	}
	
	private int accountId;
	private double balance;
	private int userId;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AccountId=" + accountId + ", Balance=" + balance + ", UserId=" + userId;
	}
	
	
	
	
	
	
	
	
	
	

}
