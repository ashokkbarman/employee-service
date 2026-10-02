package com.pravaha.repository;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.pravaha.model.Employee;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee findById(long id) {
        return employees.stream()
                .filter(employee -> employee.id() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findByDepartmentId(long departmentId) {
        return employees.stream()
                .filter(employee -> employee.departmentId() == departmentId)
                .toList();
    }

}
