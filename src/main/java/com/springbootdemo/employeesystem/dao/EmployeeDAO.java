package com.springbootdemo.employeesystem.dao;

import com.springbootdemo.employeesystem.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(int id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(int id);
}
