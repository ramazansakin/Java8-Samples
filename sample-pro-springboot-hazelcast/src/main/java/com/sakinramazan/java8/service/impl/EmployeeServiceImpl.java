package com.sakinramazan.java8.service.impl;

import com.sakinramazan.java8.dao.EmployeeDao;
import com.sakinramazan.java8.model.Employee;
import com.sakinramazan.java8.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "employees") 	// CacheConfig should be pair with hazelcast map
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    @Cacheable()
    public List<Employee> getAllEmployees() {
        System.out.println("Getting employee list to cache");
        return employeeDao.getAllEmployees();
    }

    @Override
    public void getEmployeeById(String empId) {
        Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);
    }
}