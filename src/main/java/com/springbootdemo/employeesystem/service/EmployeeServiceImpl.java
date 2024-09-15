package com.springbootdemo.employeesystem.service;

import com.springbootdemo.employeesystem.dao.EmployeeDAO;
import com.springbootdemo.employeesystem.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByID(int id) {
        return employeeDAO.getEmployeeByID(id);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
