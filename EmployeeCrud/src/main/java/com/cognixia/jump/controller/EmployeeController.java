package com.cognixia.jump.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.service.EmployeeService;
import com.cognixia.jump.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return service.getEmployees();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id){
		
		Employee found = service.getEmployeeById(id);
		if(found == null) {
			return ResponseEntity.status(404).body("Employee not found");
		}
		else {
			return ResponseEntity.status(200).body(found);
		}
	}	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id){
		Employee deleted = service.deleteEmployee(id);
		if(deleted == null) {
			return ResponseEntity.status(404).body("Nothing to Delete");
		}
		else {
			
			return ResponseEntity.status(200).header("ID", id + "").body(deleted);
		}
	}
	
	@PutMapping("/employee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		Employee updated = service.updateEmployee(employee);
		if(updated == null) {
			return ResponseEntity.status(404).body("Nothing to Update, Employee not Found");
		}
		else {
			
			return ResponseEntity.status(200).body(updated);
		}
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		System.out.println("Before Added:" + employee);
		Employee created = service.addEmployee(employee);
		return ResponseEntity.status(201).body(created);
		
	}
	
	@PatchMapping("/employee/name")
	public ResponseEntity<?> updateEmployeeName(@PathParam(value = "id") int id, @PathParam(value = "fname") String fname,  @PathParam(value = "lname") String lname){
		Employee updated = service.updateEmployeeName(id, fname, lname );
		if(updated == null) {
			return ResponseEntity.status(404).body("Nothing to Update, Employee not Found");
		}
		else {
			
			return ResponseEntity.status(200).body(updated);
		}
	}
	
	@PatchMapping("/employee/dob")
	public ResponseEntity<?> updateEmployeeDOB(@PathParam(value = "id") int id, @PathParam(value = "dob") LocalDate dob){
		Employee updated = service.updateEmployeeDOB(id, dob );
		if(updated == null) {
			return ResponseEntity.status(404).body("Nothing to Update, Employee not Found");
		}
		else {
			
			return ResponseEntity.status(200).body(updated);
		}
	}
	
	@PatchMapping("/employee/city")
	public ResponseEntity<?> updateEmployeeCity(@PathParam(value = "id") int id, @PathParam(value = "city") String city){
		Employee updated = service.updateEmployeeCity(id, city );
		if(updated == null) {
			return ResponseEntity.status(404).body("Nothing to Update, Employee not Found");
		}
		else {
			
			return ResponseEntity.status(200).body(updated);
		}
	}
	
	@PatchMapping("/employee/department")
	public ResponseEntity<?> updateEmployeeDept(@PathParam(value = "id") int id, @PathParam(value = "department") String department){
		Employee updated = service.updateEmployeeDept(id, department );
		if(updated == null) {
			return ResponseEntity.status(404).body("Nothing to Update, Employee not Found");
		}
		else {
			
			return ResponseEntity.status(200).body(updated);
		}
	}
}
