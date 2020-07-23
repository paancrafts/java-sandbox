package com.hellokoding.account.repository;

import com.hellokoding.account.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findById(long id);
	
}
