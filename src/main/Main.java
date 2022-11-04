package main;

import java.sql.SQLException;
import java.util.Scanner;

import student_management.Student;
import student_management.StudentManagement;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static Student enterStudentInformation() {
		System.out.println("Enter Student Information:\n");
		System.out.print("Enter ID: ");
		String id = sc.nextLine();
		System.out.print("Enter Full Name : ");
		String fullName = sc.nextLine();
		System.out.print("Enter Day On Birth (dd/mm/yyyy): ");
		String birthDay = sc.nextLine();
		System.out.print("Enter Gender: ");
		String gender = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		System.out.print("Enter Score: ");
		double score = sc.nextDouble();
		sc.nextLine();
		
		Student sv = new Student(id, fullName, birthDay, gender, email, score);
		return sv;
	}
	
	public static Student enterStudentID() {
		System.out.println("Enter Student ID:\n");
		System.out.print("Enter ID: ");
		String id = sc.nextLine();
		Student sv = new Student(id);
		return sv;
	}
	
	public static void main(String[] args) throws SQLException {
		StudentManagement manager = new StudentManagement();
		
		int choice = 0;
		do {
			System.out.println("---------------MENU---------------\r\n"
					+ "1. Add a student\n"
					+ "2. Print student information by student id\r\n"
					+ "3. Edit student information\r\n"
					+ "4. Remove student\r\n"
					+ "5. Print student list\r\n"
					+ "6. Print a list of students in ascending score\n"
					+ "0. Exit\n"
					+ "What function do you choose?");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				Student sv1 = enterStudentInformation();
				manager.addStudent(sv1);
				break;
				
			case 2:
				Student sv2 = enterStudentID();
				manager.searchByID(sv2);
				break;
				
			case 3:
				Student sv3 = enterStudentInformation();
				manager.editStudent(sv3);
				break;
			
			case 4:
				Student sv4 = enterStudentID();
				manager.removeStudent(sv4);
				break;
				
			case 5:
				manager.showList();
				break;
				
			case 6:
				manager.SortByScore();
				break;
				
			case 0:
				break;
			default:
				System.out.println("Wrong Function, Please select the function again!");
			}
		} while (choice != 0);
	}
}
