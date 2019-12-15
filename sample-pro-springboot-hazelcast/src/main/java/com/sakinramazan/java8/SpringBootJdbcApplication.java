package com.sakinramazan.java8;

import com.sakinramazan.java8.model.Employee;
import com.sakinramazan.java8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class SpringBootJdbcApplication {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        // creating sample test datas
        Employee e1 = new Employee("Xemployee");    // id : 1
        Employee e2 = new Employee("Yemployee");    // id : 2
        Employee e3 = new Employee("Zemployee");    // id : 3

        employeeService.insertEmployee(e1);

        // Test getEmployeeById
        Employee temp = employeeService.getEmployeeById(2);
        System.out.println("Testing getEmployeeById : " + temp);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employeeService.insertEmployees(employees);

        System.out.println("After calling getAllEmployees method of the Employee Service");
        List<Employee> employeeList1 = employeeService.getAllEmployees();
        for (Employee employee : employeeList1) {
            System.out.println(employee.toString());
        }

        System.out.println("After first call, hazelcast cached the datas and ready to work");
        List<Employee> employeeList2 = employeeService.getAllEmployees();
        for (Employee employee : employeeList2) {
            System.out.println(employee.toString());
        }

    }
}