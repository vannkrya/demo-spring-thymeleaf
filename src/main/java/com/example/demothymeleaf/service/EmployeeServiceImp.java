package com.example.demothymeleaf.service;

import com.example.demothymeleaf.model.Employee;
import com.example.demothymeleaf.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void editEmployee(Employee employee, Integer id) {
        employeeRepository.editEmployee(employee, id);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteEmployee(id);
    }
}
