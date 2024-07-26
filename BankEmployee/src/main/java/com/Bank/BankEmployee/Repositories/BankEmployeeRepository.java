package com.Bank.BankEmployee.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Bank.BankEmployee.Entities.BankEmployee;

@Repository
public interface BankEmployeeRepository extends JpaRepository<BankEmployee, Integer>{

}
