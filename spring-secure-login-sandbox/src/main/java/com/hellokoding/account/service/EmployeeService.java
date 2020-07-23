package com.hellokoding.account.service;

import java.util.List;

import com.hellokoding.account.model.Employee;

public interface EmployeeService {
    void save(Employee emp);

    Employee findById(long id);
    
    List<Employee> getAllEmployees();
    
    void delete(Employee emp);
}
