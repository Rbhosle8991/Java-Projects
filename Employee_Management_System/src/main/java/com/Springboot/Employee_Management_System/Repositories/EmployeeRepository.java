package com.Springboot.Employee_Management_System.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.Employee_Management_System.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
