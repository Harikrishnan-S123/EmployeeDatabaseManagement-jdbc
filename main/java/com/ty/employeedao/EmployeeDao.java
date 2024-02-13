package com.ty.employeedao;

import java.util.Scanner;

import com.ty.employeedto.Employee;

public interface EmployeeDao {
	//int count=0;
	Employee saveEmployee(Employee emp);
	void updateEmployeeRole(Employee emp);
	void updateEmployeeSalary(Employee emp);
	void deleteEmployee(Employee emp);
	void findEmployeefirstName(Employee emp);
	void findEmployeeSalary(Employee emp);
	void finalTasks(Scanner s);
	

}
