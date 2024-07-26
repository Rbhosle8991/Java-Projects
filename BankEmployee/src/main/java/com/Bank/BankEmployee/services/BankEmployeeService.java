package com.Bank.BankEmployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.BankEmployee.Entities.BankEmployee;
import com.Bank.BankEmployee.Repositories.BankEmployeeRepository;

@Service
public class BankEmployeeService {
	
	@Autowired
	private BankEmployeeRepository bankEmployeeRepository;
	
	public List<BankEmployee> getAllEmployees()
	{
		List<BankEmployee> list = this.bankEmployeeRepository.findAll();
		return list;
	}
	
	public BankEmployee saveEmployee(BankEmployee bankEmployee)
	{
	  return this.bankEmployeeRepository.save(bankEmployee);
	}
	
	public BankEmployee getById(int id)
	{
		return this.bankEmployeeRepository.findById(id).get();
	}

	public void deleteEmployee(int id)
	{
		this.bankEmployeeRepository.deleteById(id);
	}
}
