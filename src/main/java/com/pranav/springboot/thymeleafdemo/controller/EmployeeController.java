package com.pranav.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pranav.springboot.thymeleafdemo.entity.Employee;
import com.pranav.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}



	@GetMapping("/list")
	public String ListEmployees(Model model) {
		
		List<Employee> theEmployees = employeeService.findAll();
		model.addAttribute("employees", theEmployees);
		
		return "employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee theEmployee = new Employee();
		
		model.addAttribute("employee",theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId")int empId, Model model) {
		
		Employee theEmployee = employeeService.findById(empId);
		
		model.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId")int id) {
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
}
