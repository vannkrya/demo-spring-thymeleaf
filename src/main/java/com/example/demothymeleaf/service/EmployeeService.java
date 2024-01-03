package com.example.demothymeleaf.service;

import com.example.demothymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    Employee getEmployeeById(Integer id);

    void editEmployee(Employee employee, Integer id);

    void deleteEmployee(Integer id);
}
