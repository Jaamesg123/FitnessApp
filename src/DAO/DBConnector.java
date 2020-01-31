package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static final String URL = "jdbc:mysql://localhost:3306/FitnessDB";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection instance;
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				instance = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			} catch (SQLException e) {
				System.out.println("Connection Failed!!");
				e.printStackTrace();
			}
			
		}
		return instance;
		
	}

}