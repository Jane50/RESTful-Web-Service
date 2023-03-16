package com.example.Employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeApplicationTests {
    @Mock
    private EmployeeDAO employeeDAO;

    // Helper function to get the number of current employees
    int getEmployeeCount(EmployeeDAO dao) {
        return dao.getAllEmployees().getEmployees().size();
    }

    @Test
        // Ensure that employee list is populated on initialization
    void createEmployeeDao() {
        EmployeeDAO newEmployeeDAO = new EmployeeDAO();
        assert (getEmployeeCount(newEmployeeDAO) != 0);
    }

    @Test
        // Ensure that adding an employee increases the employee count by 1
    void addEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        int employeeCount = getEmployeeCount(employeeDAO);
        Employee employee = new Employee("djones3", "Daria", "Jones", "dariajones@gmail.com", "Software developer");
        employeeDAO.addEmployee(employee);
        assert (employeeCount + 1 == getEmployeeCount(employeeDAO));
    }

    @ExtendWith(MockitoExtension.class)
    @BeforeEach
    void setUp() {
        this.employeeDAO = new EmployeeDAO();
        Employee newEmployee = new Employee("djones3", "Daria", "Jones", "dariajones@gmail.com", "Software developer");
        this.employeeDAO.addEmployee(newEmployee);
    }

    @Test
        // Check whether added employee ID is found in ID field
    void employeeIdInList() {
        List<Employee> employees = this.employeeDAO.getAllEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmployee_id() == "djones3") {
                return;
            }
        }
        assert (false);
    }

    @Test
        // Check whether added employee first name is found in first name field
    void employeeFirstNameInList() {
        List<Employee> employees = this.employeeDAO.getAllEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getFirst_name() == "Daria") {
                return;
            }
        }
        assert (false);
    }

    @Test
        // Check whether added employee last name is found in last name field
    void employeeLastNameInList() {
        List<Employee> employees = this.employeeDAO.getAllEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getLast_name() == "Jones") {
                return;
            }
        }
        assert (false);
    }

    @Test
        // Check whether added employee email is found in email field
    void employeeEmailInList() {
        List<Employee> employees = this.employeeDAO.getAllEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getEmail() == "dariajones@gmail.com") {
                return;
            }
        }
        assert (false);
    }

    @Test
        // Check whether added employee title is found in title field
    void employeeTitleInList() {
        List<Employee> employees = this.employeeDAO.getAllEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getTitle() == "Software developer") {
                return;
            }
        }
        assert (false);
    }
}
