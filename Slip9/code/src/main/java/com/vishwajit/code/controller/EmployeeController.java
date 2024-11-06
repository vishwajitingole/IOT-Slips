package com.vishwajit.code.controller;

import com.vishwajit.code.model.Employee;
import com.vishwajit.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Add a new employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Update employee details
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
