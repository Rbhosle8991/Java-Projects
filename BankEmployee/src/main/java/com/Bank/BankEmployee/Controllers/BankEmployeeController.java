package com.Bank.BankEmployee.Controllers;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Bank.BankEmployee.Entities.BankEmployee;
import com.Bank.BankEmployee.services.BankEmployeeService;

@Controller
public class BankEmployeeController {
	
	@Autowired
	private BankEmployeeService bankEmployeeService;
	
	@GetMapping("/employee")
	public String getAllEmployees(Model model)
	{
		model.addAttribute("employees", this.bankEmployeeService.getAllEmployees());
		return "employee";
	}
	
	@GetMapping("/employee/new")
	public String createEmployeeForm(Model model)
	{
		BankEmployee bankEmployee = new BankEmployee();
		model.addAttribute("employee", bankEmployee);
		return "create-Employee";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") BankEmployee bankEmployee)
	{
		this.bankEmployeeService.saveEmployee(bankEmployee);
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String editStudentForm(@PathVariable int id , Model model)
	{
		model.addAttribute("employee", this.bankEmployeeService.getById(id));
		return "edit_employee";
	}

	@PostMapping("/employee/edit/{id}")
	public String updateEmployee(@PathVariable int id , @ModelAttribute("employee") BankEmployee bankEmployee)
	{
		BankEmployee existingEmployee = this.bankEmployeeService.getById(id);
		
		existingEmployee.setFirstName(bankEmployee.getFirstName());
		existingEmployee.setLastName(bankEmployee.getLastName());
		existingEmployee.setAge(bankEmployee.getAge());
		existingEmployee.setEmail(bankEmployee.getEmail());
		existingEmployee.setCity(bankEmployee.getCity());
		
		this.bankEmployeeService.saveEmployee(bankEmployee);
		return "redirect:/employee";
	}
	
	@GetMapping("/employee/{id}")
	public String delete(@PathVariable int id)
	{
		this.bankEmployeeService.deleteEmployee(id);
		return "redirect:/employee";
	}
}
