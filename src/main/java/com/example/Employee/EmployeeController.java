package com.example.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/", produces = "application/json")
    public Employees getEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        String employee_id = employee.getEmployee_id();
        employee.setEmployee_id(employee_id);
        employeeDAO.addEmployee(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employee_id}").buildAndExpand(employee.getEmployee_id()).toUri();
        return ResponseEntity.created(location).build();
    }
}
