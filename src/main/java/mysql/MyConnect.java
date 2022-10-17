package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnect {
	public static Connection getConnection() {
		Connection conn = null;
		try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/ltwbs";
            String user = "admin";
            String pass = "admin";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		return conn;
	}
}
