package com.jsp.hibernate.employeedb.dao;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.employeedb.entity.Employee;

public class EmployeeDAO {
	public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}

	public static void addEmployee() {
		
		Employee e = new Employee();
		Scanner sc =new Scanner(System.in);

		Session session=getSession();
		Transaction t=session.beginTransaction();

		System.out.println("Enter your Id");
		e.setEmployeeID(sc.nextInt());
		System.out.println("Enter your Name");
		e.setEmployeeName(sc.next());
		System.out.println("Enter your email");
		e.setEmployeeEmail(sc.next());
		System.out.println("Enter your Age");
		e.setEmployeeAge(sc.nextInt());
		System.out.println("Enter your Designation");
		e.setEmployeeDesc(sc.next());
		System.out.println("Enter your Salary");
		e.setEmployeeSalary(sc.nextInt());

		session.save(e);

		t.commit();
		getSession().close();
		session.close();
	}

	public static void findEmployeeById() {

		Scanner sc = new Scanner(System.in); 
		
		Session session=getSession();
		Transaction t1 =session.beginTransaction();
		
		Employee e1 = null;

		System.out.print("Enter your ID: ");
		int empId = sc.nextInt();
		sc.nextLine(); // Consume leftover newline
		e1 = session.get(Employee.class, empId); // Use session.get() to avoid exceptions

		if (e1 == null) {
			System.out.println("Employee not found with ID: " + empId);
			return;
		}

		System.out.println(e1);
		t1.commit();
		session.close();
	}

	public static void updateEmployeeDescAndSalaryById() {


		Scanner sc = new Scanner(System.in); // Fix Scanner initialization
		
		Session session = getSession();
		Transaction t2 = session.beginTransaction();

		Employee e3 = null; // Initialize the Employee object

		try {
			System.out.print("Enter your ID: ");
			int empId = sc.nextInt();
			sc.nextLine(); // Consume leftover newline
			
			e3 = session.get(Employee.class, empId); // Use session.get() to avoid exceptions

			if (e3 == null) {
				System.out.println("Employee not found with ID: " + empId);
				return;
			}

			System.out.print("Enter your Designation: ");
			e3.setEmployeeDesc(sc.nextLine());

			System.out.print("Enter your Salary: ");
			if (sc.hasNextInt()) {
				e3.setEmployeeSalary(sc.nextInt());
			} else {
				System.out.println("Invalid salary input. Update failed.");
				return;
			}

			session.update(e3); // Update the employee
			t2.commit(); // Commit the transaction
			System.out.println("Employee updated successfully.");
			
		} 
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Update failed.");
			sc.nextLine(); // Clear invalid input
		} 
		catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
			t2.rollback(); // Rollback the transaction on failure
		}
		finally {
			session.close(); // Close the session
			sc.close(); // Close the scanner
		}
	}

	public static void deleteEmployeeById() {
		
		Scanner sc= new Scanner(System.in);
		Session session=getSession();
		Transaction t3=session.beginTransaction();
		
		System.out.println("Enter your Id");
		Employee e4 = session.get(Employee.class, sc.nextInt());
		
		session.delete(e4);
		
		t3.commit();
		getSession().close();
		session.close();
	}
}