package com.pranav.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	//sort by last name custom method
	public List<Employee> findAllByOrderByLastNameAsc();
}
