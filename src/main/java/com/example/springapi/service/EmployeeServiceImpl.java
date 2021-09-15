package com.example.springapi.service;

import com.example.springapi.entity.Employee;
import com.example.springapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }
    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Employee updateById(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setFirst_name(employee.getFirst_name());
        employee1.setLast_name(employee.getLast_name());
        employee1.setEmail(employee.getEmail());
        employeeRepository.save(employee1);
        return employee1;
    }
}
