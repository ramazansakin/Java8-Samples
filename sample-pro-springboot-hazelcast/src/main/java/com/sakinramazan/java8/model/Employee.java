package com.sakinramazan.java8.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Builder
@ToString
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

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}