package com.springbootdemo.employeesystem.rest;

import com.springbootdemo.employeesystem.entity.Employee;
import com.springbootdemo.employeesystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeByID(@PathVariable int id) {
        Employee employee = this.employeeService.getEmployeeByID(id);

        if(employee == null) {
            throw new RuntimeException("Employee id not found: " + id);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return this.employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = this.employeeService.getEmployeeByID(id);

        if (employee == null) {
            throw new RuntimeException("No employee with the ID of: " + id);
        }

        this.employeeService.deleteEmployee(id);

        return "Deleted employee by ID: " + id;
    }
}
