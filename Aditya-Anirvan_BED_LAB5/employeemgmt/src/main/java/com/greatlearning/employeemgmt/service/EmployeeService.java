package com.greatlearning.employeemgmt.service;

 import java.util.*;

import com.greatlearning.employeemgmt.model.Employee;
public interface EmployeeService {

		public List<Employee> getAllEmployees();
		public void saveOrUpdate(Employee emp);
		public void deleteEmployeeById(int id);
		public Employee getEmployeeById(int id);
}
