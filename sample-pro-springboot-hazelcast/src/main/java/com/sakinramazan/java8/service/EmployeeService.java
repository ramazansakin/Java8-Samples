package com.sakinramazan.java8.service;

import com.sakinramazan.java8.model.Employee;

import java.util.List;

public interface EmployeeService {
    void insertEmployee(Employee emp);

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer empid);
}