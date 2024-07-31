package com.Springboot.Employee_Management_System.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Employee_Management_System.Entity.Employee;
import com.Springboot.Employee_Management_System.Services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return this.employeeService.getAllEmployees();
	}
	
	@PostMapping("/add")
	public Employee addEmployees(@RequestBody Employee employee)
	{
		return this.employeeService.add(employee);
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return this.employeeService.getById(id);
		
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee , @PathVariable Long id)
	{
		return this.employeeService.update(employee, id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id)
	{
		this.employeeService.delete(id);
	}

}
