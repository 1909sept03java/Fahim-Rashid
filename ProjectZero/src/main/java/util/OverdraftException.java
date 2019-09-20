package util;

import java.io.IOException;
import java.sql.SQLException;


public class OverdraftException extends Exception {
	

	
	public OverdraftException(String ex) throws SQLException, IOException, OverdraftException {
		//super();
		System.out.println("Withdrawal amount cannot be greater than current balance");
	
	}
}
