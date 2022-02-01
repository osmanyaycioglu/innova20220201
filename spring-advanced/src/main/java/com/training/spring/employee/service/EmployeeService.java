package com.training.spring.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lib.spring.Employee;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void add(final Employee employeeParam) {
        this.employees.add(employeeParam);
    }


}
