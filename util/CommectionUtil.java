package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CommectionUtil {

	/*public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:oracle:thin:@fahims-database.cskvyzayy80d.us-east-2.rds.amazonaws.com.rds.amazonaws.com:1521:orcl", "fahimrashid1992", "Deeshumoni1.");
	}

	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties();
		prop.load(CommectionUtil.class.getClassLoader().getResourceAsStream("src\\main\\resources\\connection.properties"));
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
				
	}*/


public static Connection getConnection() throws SQLException, IOException {
    Properties prop = new Properties();
    InputStream in = new FileInputStream("src\\main\\resources\\connection.properties");
    prop.load(in);
    // need to provide: url to db, username, password
    // read in the contents of a properties file
    return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
	}
}