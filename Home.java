package com.student_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Home {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to Delete student");
			System.out.println("Press 3 to Update student");
			System.out.println("Press 4 to Display student");
			System.out.println("Press 5 to Exit App  ");
			int userInput = Integer.parseInt(br.readLine());
			
			if(userInput == 1) {
				// 1. Inserting Student Data 
				
				//System.out.println("Enter the student ID: ");
				//int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter the student name: ");
				String name = br.readLine();
				
				System.out.println("Enter the student phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter the student city: ");
				String city = br.readLine();
				
				Student st = new Student(name, phone, city);
				boolean ans = StudentDB.insertStudentToDB(st);
				if(ans) {
					System.out.println("Student is added successfuly...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
			}
			else if(userInput == 2) {
				// 2. Deleting Student Data
				System.out.println("Enter student id to Delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean ans = StudentDB.deleteStudent(userId);
				if(ans) {
					System.out.println("Student is deleted successfuly...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
			}
			else if(userInput == 3) {
				// 3. Update Students
				System.out.println("Enter the student name: ");
				String name = br.readLine();
				
				System.out.println("Enter the student phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter the student city: ");
				String city = br.readLine();
				
				System.out.println("Enter student id to Update: ");
				int userId = Integer.parseInt(br.readLine());
				
				StudentDB.updateStudent(name, phone, city, userId);
			}
			else if(userInput == 4) {
				// 4. Displaying Students
				StudentDB.displayStudents();
			}
			else if(userInput == 5) {
				// 5. Exit App
				break;
			}
			else {
				System.out.println("Invalid Input");
			}
			
		}
		
		System.out.println("Thankyou for using my application");

	}

}
