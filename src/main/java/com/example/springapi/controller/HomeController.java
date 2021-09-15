package com.example.springapi.controller;

import com.example.springapi.entity.Employee;
import com.example.springapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    private EmployeeService employeeService;

    @Autowired
    public HomeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllStudents(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getStudentById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public String saveStudent(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return "add thanh cong";
    }

    @PutMapping("/employees/{id}")
    public Employee updateStudent(@PathVariable("id") Long id,@RequestBody Employee employee){
        return employeeService.updateById(id,employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return "delete thanh cong";
    }
}
