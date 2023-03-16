package com.example.Employee;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    private static Employees list = new Employees();

    static {
        list.getEmployees().add(new Employee(
                "1", "Prem", "Tiwari",
                "chapradreams@gmail.com", "Software Engineer"
        ));
        list.getEmployees().add(
                new Employee(
                        "2", "Vikash", "Kumar",
                        "abc@gmail.com", "Designer"
                )
        );

        list.getEmployees().add(
                new Employee(
                        "3", "Ritesh", "Ojha",
                        "abc@gmail.com", "Accountant"
                )
        );
    }

    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployees().add(employee);
    }
}
