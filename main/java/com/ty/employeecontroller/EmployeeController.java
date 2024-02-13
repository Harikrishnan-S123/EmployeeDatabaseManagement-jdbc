package com.ty.employeecontroller;

import java.sql.Connection;
import java.util.Scanner;

import com.ty.employeedao.EmployeeDao;
import com.ty.employeedao.EmployeeDaoImplement;
import com.ty.employeedto.Employee;
import com.ty.helperClasses.ConnectionPool;
import com.ty.helperClasses.GetTheIndex;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		EmployeeDao e=new EmployeeDaoImplement();
		Employee e2=new Employee();
		System.out.println("welcome to Employee db");
		boolean flag=true;
		try {
		while(flag) {
			System.out.println("Enter your choice");
			System.out.println("1.save the employee");
			System.out.println("2.update the employee");
			System.out.println("3.delete the emeployee");
			System.out.println("4.find the emeployee");
			System.out.println("5.exit");
			int choice=s.nextInt();
			switch(choice)
			{
			case 1:{
				e.saveEmployee(e2);
				//System.out.println("Inserted");
			}
			break;
			case 2:{
				//System.out.println("Updated");
				System.out.println("Press 1-role");
				System.out.println("Press 2-salry");
				switch(s.nextInt()) {
				case 1:
				{
					e.updateEmployeeRole(e2);
					//System.out.println("Updated role");
	
				}
				break;
				case 2:
				{
					e.updateEmployeeSalary(e2);
					//System.out.println("Updated salary");
				}
				break;
				}
			}
			break;
			case 3:{
				e.deleteEmployee(e2);
				
				
			}
			break;
			case 4:{
				System.out.println("Press 1-Salary range sort");
				System.out.println("Press 2-first name sort");
				switch(s.nextInt()) {
				case 1:{
					e.findEmployeeSalary(e2);
				}break;
				case 2:{
					e.findEmployeefirstName(e2);
				}
				break;
			}
			}
			break;
			case 5:{
				flag=false;
			}
			break;
			default:{
				System.out.println("Enter valid");
			}
				

			}
			


		}
		s.close();
		e.finalTasks(s);
		}
		catch (Exception ex) {
			System.out.println("some unexpected error occured");
		}
	}
	

}
