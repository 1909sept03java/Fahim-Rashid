package dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import beans.BankAccounts;

public interface BankgAccountDAO {
	
	public List<BankAccounts> getBankAccounts() throws SQLException, IOException;
	//public BankAccounts getAccount();

}
