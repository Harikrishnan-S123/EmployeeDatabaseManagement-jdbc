package com.ty.employeedto;

public class Employee {
	private String eid;
	private String companyname;
	private String firstname;
	private String lastname;
	private String role;
	private int salary;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	private String mail;
	public Employee(String eid, String companyname, String firstname, String lastname, String role, int salary,
			String mail) {
		super();
		this.eid = eid;
		this.companyname = companyname;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
		this.salary = salary;
		this.mail = mail;
	}
	public Employee() {
		
	}
	

}
