package com.jsp.hibernate.employeedb;

import java.util.Scanner;

import com.jsp.hibernate.employeedb.dao.EmployeeDAO;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose an operation:");
		System.out.println("1. Add Employee");
		System.out.println("2. Find Employee by ID");
		System.out.println("3. Update Employee Description and Salary by ID");
		System.out.println("4. Delete Employee by ID");
		System.out.println("5. Exit");

		int choice = sc.nextInt();


		switch (choice) {
		case 1:
			EmployeeDAO.addEmployee();
			break;
		case 2:
			EmployeeDAO.findEmployeeById();
			break;
		case 3:
			EmployeeDAO.updateEmployeeDescAndSalaryById();
			break;
		case 4:
			EmployeeDAO.deleteEmployeeById();
			break;
		case 5:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid choice! Please select a valid option.");
		}

	}
}
