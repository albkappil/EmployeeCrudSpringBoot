package com.cognixia.jump.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Employee;

@Service
public class EmployeeService {
	private static List<Employee> employeeDB = new ArrayList<Employee>();
	private static int idCounter = 1;
	
	static {
		employeeDB.add(new Employee(idCounter++, "Tweety", "Bird", LocalDate.of(2004, 5, 30),"New Jersey", "HR"));
		employeeDB.add(new Employee(idCounter++, "Bugs" ," Bunney", LocalDate.of(2004, 5, 30),"Los Angeles", "Computer Science"));
		employeeDB.add(new Employee(idCounter++, "Daffy" , "Duck", LocalDate.of(2004, 5, 30),"San Francisco", "Medical"));
	}
	
	public List<Employee> getEmployees(){
		return employeeDB;
	}

	public Employee getEmployeeById(int id) {
	
		for(Employee s: employeeDB) {
			if(s.getId() == id)
					return s;
		}
		return null;
	}
	
	
	public Employee deleteEmployee(int id) {
		
		Employee toDelete = getEmployeeById(id);
		
		Boolean removed  = employeeDB.remove(toDelete);
		
		if(removed)
			return toDelete;
		else
			return null;
	}
	
	public Employee updateEmployee(Employee employee) {
			
			Employee toUpdate = getEmployeeById(employee.getId());
			
		
			if(toUpdate == null)
				return null;
			else {
				toUpdate.setFname(employee.getFname());
				toUpdate.setLname(employee.getLname());
				toUpdate.setDob(employee.getDob());
				toUpdate.setCity(employee.getCity());
				toUpdate.setDepartment(employee.getDepartment());
				
				return toUpdate;
			}
			
		}
	
	
	public Employee addEmployee(Employee employee) {
		
		if(employee.getId() == -1)
			employee.setId(idCounter++);
		employeeDB.add(employee.getId()-1, employee);
		return employee;
	}
		
	
	public Employee updateEmployeeName(@PathParam(value = "id") int id, @PathParam(value = "fname") String fname,  @PathParam(value = "lname") String lname) {
		
		Employee toUpdate = getEmployeeById(id);
		
	
		if(toUpdate == null)
			return null;
		else {
			toUpdate.setFname(fname);
			toUpdate.setLname(lname);
			
			return toUpdate;
		}
		
	}
	
	public Employee updateEmployeeDOB(@PathParam(value = "id") int id, @PathParam(value = "fname") LocalDate dob) {
		
		Employee toUpdate = getEmployeeById(id);
		
	
		if(toUpdate == null)
			return null;
		else {
			toUpdate.setDob(dob);
			return toUpdate;
		}
		
	}
	
	public Employee updateEmployeeCity(@PathParam(value = "id") int id, @PathParam(value = "city") String city) {
		
		Employee toUpdate = getEmployeeById(id);
		
	
		if(toUpdate == null)
			return null;
		else {
			toUpdate.setCity(city);
			return toUpdate;
		}
		
	}
	
	public Employee updateEmployeeDept(@PathParam(value = "id") int id, @PathParam(value = "department") String department) {
		
		Employee toUpdate = getEmployeeById(id);
		
	
		if(toUpdate == null)
			return null;
		else {
			toUpdate.setDepartment(department);
			return toUpdate;
		}
		
	}


	
}
