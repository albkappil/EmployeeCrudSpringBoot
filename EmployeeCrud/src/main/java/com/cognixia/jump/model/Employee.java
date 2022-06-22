package com.cognixia.jump.model;

import java.time.LocalDate;

public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private LocalDate dob;
	private String city;
	private String department;
	
	public Employee() {
			this(-1, "N/A","N/A", LocalDate.now(),"Unknown", "Undecided");
	}

	
	public Employee(int id, String fname, String lname, LocalDate dob, String city, String department) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.city = city;
		this.department = department;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	

	
	
	
	
	

}
