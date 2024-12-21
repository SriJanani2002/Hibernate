package com.jsp.hibernate.employeedb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int employeeID;
	private String EmployeeName;
	private String EmployeeEmail;
	private int EmployeeAge;
	private String EmployeeDesc;
	private int EmployeeSalary;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	public int getEmployeeAge() {
		return EmployeeAge;
	}
	public void setEmployeeAge(int employeeAge) {
		EmployeeAge = employeeAge;
	}
	public String getEmployeeDesc() {
		return EmployeeDesc;
	}
	public void setEmployeeDesc(String employeeDesc) {
		EmployeeDesc = employeeDesc;
	}
	public int getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		EmployeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee found with id:"+this.employeeID; 
	}
}
