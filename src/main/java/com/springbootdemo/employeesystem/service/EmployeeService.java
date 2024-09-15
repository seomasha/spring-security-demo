package com.springbootdemo.employeesystem.service;

import com.springbootdemo.employeesystem.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
