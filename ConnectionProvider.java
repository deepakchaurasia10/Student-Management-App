package com.student_manager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con; 
	
	public static Connection createConnection() {
		try {
			// 1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Create the Connection 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manager", "root", "1015");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
