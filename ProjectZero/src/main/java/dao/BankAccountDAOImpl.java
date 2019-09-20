package dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.BankAccounts;
import util.ConnectionUtil;

public class BankAccountDAOImpl implements BankgAccountDAO {

	@Override
	public List<BankAccounts> getBankAccounts() throws SQLException, IOException {
		List<BankAccounts> bankAccounts = new ArrayList<>();

		try(Connection con=ConnectionUtil.getConnection() ){
			String sql = "SELECT*FROM BANK_ACCOUNTS";

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int accountId = rs.getInt("BANK_ACCOUNT_ID");
				double balance =  rs.getDouble("BALANCE");
				int userId =  rs.getInt("USER_ID");
				bankAccounts.add(new BankAccounts(accountId,balance,userId));
				System.out.println("Execution complete");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		return bankAccounts;
	}

}
