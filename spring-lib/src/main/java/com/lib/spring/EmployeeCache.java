package com.lib.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class EmployeeCache {

    private final Map<String, Employee> employeeMap = new ConcurrentHashMap<>();

    public void add(final Employee employeeParam) {
        this.employeeMap.put(employeeParam.getUsername(),
                             employeeParam);
    }

}
