package com.pravaha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pravaha.model.Employee;
import com.pravaha.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Adding employee: {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@RequestAttribute("id") long id) {
        logger.info("Fetching employee with id: {}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartmentId(@RequestAttribute("departmentId") long departmentId) {
        logger.info("Fetching employees for department id: {}", departmentId);
        return employeeRepository.findByDepartmentId(departmentId);
    }

}
