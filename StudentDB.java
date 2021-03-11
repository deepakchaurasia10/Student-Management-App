package com.student_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDB {

	public static boolean insertStudentToDB(Student st) {
		//JDBC COde for Inserting Data
		boolean f = false;
		try {
			
			Connection con = ConnectionProvider.createConnection();
			String q = "insert into students(sid, sname, sphone, scity) values(?, ?, ?, ?)";
			
			//PreparedStatement
			PreparedStatement ps = con.prepareStatement(q);
			
			//Set the value of parameter
			ps.setInt(1, st.getStudentId());
			ps.setString(2, st.getStudentName());
			ps.setString(3, st.getStudentPhone());
			ps.setString(4, st.getStudentCity());
			
			//Execute
			ps.executeUpdate();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f = false;
		try {
			
			Connection con = ConnectionProvider.createConnection();
			String q = "delete from students where sid=?";
			
			//PreparedStatement
			PreparedStatement ps = con.prepareStatement(q);
			
			//Set the value of parameter
			ps.setInt(1, userId);
			
			
			//Execute
			ps.executeUpdate();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void displayStudents() {
		
		try {
			
			Connection con = ConnectionProvider.createConnection();
			String q = "select * from students";
			
			Statement ps = con.createStatement();
			ResultSet set = ps.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID : " + id);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("City : " + city);
				System.out.println("+++++++++++++++++++++++++++++++++");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void updateStudent(String name, String phone, String city, int id) {
		
		
		try {
			
			Connection con = ConnectionProvider.createConnection();
			String q = "update students set sname=? , sphone=?, scity=? where sid=?";
			
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, city);
			ps.setInt(4, id);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
