package com.example.springapi.service;

import com.example.springapi.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeeService  {
    List<Employee> findAll();

    Employee getEmployeeById(Long id);

    void createEmployee(Employee employee);

    void deleteById(Long id);

    Employee updateById(Long id,Employee employee);
}
