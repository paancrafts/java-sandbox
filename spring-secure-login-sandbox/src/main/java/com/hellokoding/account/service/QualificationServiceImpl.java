package com.hellokoding.account.service;

import com.hellokoding.account.model.Employee;
import com.hellokoding.account.model.Qualification;
import com.hellokoding.account.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl implements QualificationService {
	@Autowired
    private EmployeeRepository employeeRepository;
	

	@Override
	public void save(Qualification qual) {
		Employee emp=employeeRepository.getOne(qual.getEmployeeId());
		emp.getQualifications().add(qual);
		employeeRepository.save(emp);
	}

	@Override
	public Qualification findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Qualification> getAllQualifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Qualification qual) {
		// TODO Auto-generated method stub
		
	}
    
}
