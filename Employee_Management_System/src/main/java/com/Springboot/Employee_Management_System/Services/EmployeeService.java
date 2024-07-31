package com.Springboot.Employee_Management_System.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Employee_Management_System.Entity.Employee;
import com.Springboot.Employee_Management_System.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> list = this.employeeRepository.findAll();
		return list;
	}
	
	
	public Employee add(Employee employee)
	{
		return this.employeeRepository.save(employee);
	}
	
	
	public Employee getById(Long id)
	{
		return this.employeeRepository.findById(id).get();
	}
	
	
	public Employee update(Employee employee , Long id)
	{
		employee.setId(id);
		return this.employeeRepository.save(employee);
	}
	
	
	public void delete(Long id)
	{
		this.employeeRepository.deleteById(id);
	}

}
