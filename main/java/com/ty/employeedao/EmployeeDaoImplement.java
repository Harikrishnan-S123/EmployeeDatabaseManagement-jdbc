package com.ty.employeedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ty.employeedto.Employee;
import com.ty.helperClasses.ConnectionPool;
import com.ty.helperClasses.GetTheIndex;
import com.ty.helperClasses.Helper;

public class EmployeeDaoImplement implements EmployeeDao {
	Scanner sc=new Scanner(System.in);
	Connection connection=ConnectionPool.getConnection();
	int count= GetTheIndex.getLastRowIndex(connection)+1;

	@Override
	public Employee saveEmployee(Employee emp) {
		
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
			String s="TYC";
			String id=s+(count++);
			preparedStatement.setString(1, id);
			System.out.println("Enter the company name");
			String companyname=sc.next();
			preparedStatement.setString(2,companyname);
			System.out.println("Enter the firstname");
			String firstname=sc.next();
			preparedStatement.setString(3,firstname);
			System.out.println("Enter the lastname");
			String lastname=sc.next();
			preparedStatement.setString(4,lastname);
			System.out.println("Enter the role");
			String role=sc.next();
			preparedStatement.setString(5,role);
			System.out.println("Enter the salry");
			int sal=0;
			try {
			 sal=sc.nextInt();
			}
			catch (Exception e) {
				System.out.println("You have put invalid date");
				
			}
			preparedStatement.setInt(6,sal);
			System.out.println("Enter the mail");
			String mail=sc.next();
			preparedStatement.setString(7,mail);
			preparedStatement.execute();
			System.out.println(id+" inserted");
			emp.setEid(id);
			emp.setFirstname(firstname);
			emp.setCompanyname(companyname);
			emp.setLastname(lastname);
			emp.setRole(role);
			emp.setSalary(sal);
			emp.setMail(mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}

	@Override
	public void updateEmployeeRole(Employee emp) {
		try {
			if(Helper.isEmpty()) {
				PreparedStatement preparedStatement=connection.prepareStatement("update employee set role=? where eid=?");
				System.out.println("Enter id");
				String eid=sc.next();
				preparedStatement.setString(2, eid);
				System.out.println("Enter new role");
				String role=sc.next();
				preparedStatement.setString(1, role);
				int c=preparedStatement.executeUpdate();
				if(c==0) {
					System.out.println("Error not possible because id not present");
				}
				else
					System.out.println("Updated Role");
			}
			else {
				System.out.println("Sorry no data");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try {
			if(Helper.isEmpty()) {
				PreparedStatement preparedStatement=connection.prepareStatement("delete from employee where eid=?");
				System.out.println("Enter id");
				String id=sc.next();
				preparedStatement.setString(1, id);
				int c=preparedStatement.executeUpdate();
				if(c==0)
					System.out.println("given id not present");
				else
					System.out.println("deleted");
			}
			else {
				System.out.println("Non data present");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void findEmployeeSalary(Employee emp) {
		try {
			if(Helper.isEmpty()) {
				PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where salary  between ? and ?");
				System.out.println("Enter lower salry");
				preparedStatement.setInt(1, sc.nextInt());
				System.out.println("Enter upper salry");
				preparedStatement.setInt(2, sc.nextInt());
				ResultSet rs=preparedStatement.executeQuery();
	            boolean flag=rs.next();
	            if(flag==false) {
					System.out.println("No data present");
				}
				while(flag) {
					//
					System.out.println("Done");
					System.out.println("ID: "+rs.getString(1));
					System.out.println("Name: "+rs.getString(3)+" "+rs.getString(4));
					System.out.println("_________________");
					flag=rs.next();
					
				}
				//System.out.println("No data with specified salry exist");
			}
			else
				System.out.println("NO data present");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void updateEmployeeSalary(Employee emp) {
		// TODO Auto-generated method stub
		try {
			if(Helper.isEmpty()) {
				PreparedStatement preparedStatement=connection.prepareStatement("update employee set salary=? where eid=?");
				System.out.println("Enter id");
				String id=sc.next();
				preparedStatement.setString(2, id);
				System.out.println("Enter new sal");
				int sal=sc.nextInt();
				preparedStatement.setInt(1, sal);
				int c=preparedStatement.executeUpdate();
				//System.out.println(preparedStatement.executeUpdate());
				if(c!=1)
					System.out.println("Sorry given id not present");
				else
					System.out.println("Updated salary");
			}
			else {
				System.out.println("No data present");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void findEmployeefirstName(Employee emp) {
		try {
			if(Helper.isEmpty()) {
				PreparedStatement preparedStatement=connection.prepareStatement("select * from employee where firstname=?");
				System.out.println("Enter first name");
				preparedStatement.setString(1, sc.next());
				ResultSet rs=preparedStatement.executeQuery();
				boolean flag=rs.next();
				if(flag==false) {
					System.out.println("No data present");
				}
				while(flag) {
					System.out.println("Done");
					System.out.println("ID: "+rs.getString(1));
					System.out.println("Name: "+rs.getString(3)+" "+rs.getString(4));
					System.out.println("_________________");
					flag=rs.next();
				}
				
			}
			else
				System.out.println("NO data present");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void finalTasks(Scanner s) {
		s.close();
		sc.close();
		ConnectionPool.recieveConnection(connection);
		
		
		
	}
	
	
	

}
