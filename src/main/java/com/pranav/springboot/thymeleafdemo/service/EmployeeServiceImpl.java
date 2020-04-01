package com.pranav.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pranav.springboot.thymeleafdemo.dao.EmployeeRepo;
import com.pranav.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		//return employeeRepo.findAll();
		return employeeRepo.findAllByOrderByLastNameAsc();
	}


	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result = employeeRepo.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("did not find employee id of "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
		employeeRepo.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(theId);
	}

}
