package com.sakinramazan.java8.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int id = 0;
    private Integer empId;
    private String empName;

    public Employee() {
        this.empId = id++;
    }

    public Employee(String empName) {
        this.empId = id++;
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + "]";
    }

}