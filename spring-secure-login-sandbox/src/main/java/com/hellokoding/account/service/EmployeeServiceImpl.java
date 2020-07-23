package com.hellokoding.account.service;

import com.hellokoding.account.model.Employee;
import com.hellokoding.account.repository.EmployeeRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee emp) {
    	emp.setDate(dateTime());
        employeeRepository.save(emp);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.getOne(id);
    }
    
    @Override
	public List<Employee> getAllEmployees() {
    	return employeeRepository.findAll();
    }
    
    @Override
	public void delete(Employee emp) {
    	employeeRepository.delete(emp);
    }
    
    private String dateTime() {
		DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd");
		Date date = Calendar.getInstance().getTime();
		return dateFormat.format(date);
	}
}
