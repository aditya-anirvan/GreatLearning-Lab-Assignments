package com.greatlearning.employeemgmt.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeemgmt.model.Employee;
import com.greatlearning.employeemgmt.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		List<Employee> result = service.getAllEmployees();
		model.addAttribute("employees", result);
		return "employees";
	}

	@GetMapping("/employees/new")
	public String addNewEmployees(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "create_employee";
	}

	@GetMapping("/employees/edit/{id}")
	public String updateEmployees(Model model, @PathVariable("id") int id) {
		Employee emp = service.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "edit_employee";
	}

	@GetMapping("/employees/delete/{id}")
	public String deleteEmployees(@PathVariable("id") int id) {
		service.deleteEmployeeById(id);
		return "redirect:/employees";
	}

	@PostMapping("/employees")
	public String addEmployees(@ModelAttribute(name = "employee") Employee emp) {
		service.saveOrUpdate(emp);
		return "redirect:/employees";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployees(@ModelAttribute(name = "employee") Employee emp, @PathVariable
			("id") int id) {
		Employee existingEmp = service.getEmployeeById(id);
		if (existingEmp.getId() == emp.getId()) {
			existingEmp.setFirstName(emp.getFirstName());
			existingEmp.setLastName(emp.getLastName());
			existingEmp.setEmail(emp.getEmail());
			service.saveOrUpdate(existingEmp);
		}
		return "redirect:/employees";
	}

}
