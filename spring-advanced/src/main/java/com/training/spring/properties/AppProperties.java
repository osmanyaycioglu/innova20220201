package com.training.spring.properties;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.lib.spring.Employee;

@Component
@ConfigurationProperties("xyz.prop")
// @Validated
public class AppProperties {

    @NotEmpty
    @Size(min = 3, max = 20)
    private String                name;
    @Max(2000)
    @Min(1024)
    private Integer               port;
    private Employee              employee;
    private List<String>          strs;
    private List<Employee>        employees;
    private Map<String, Employee> employeMap;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(final Integer portParam) {
        this.port = portParam;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(final Employee employeeParam) {
        this.employee = employeeParam;
    }

    public List<String> getStrs() {
        return this.strs;
    }

    public void setStrs(final List<String> strsParam) {
        this.strs = strsParam;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(final List<Employee> employeesParam) {
        this.employees = employeesParam;
    }

    public Map<String, Employee> getEmployeMap() {
        return this.employeMap;
    }

    public void setEmployeMap(final Map<String, Employee> employeMapParam) {
        this.employeMap = employeMapParam;
    }

    @Override
    public String toString() {
        return "AppProperties [name="
               + this.name
               + ", port="
               + this.port
               + ", employee="
               + this.employee
               + ", strs="
               + this.strs
               + ", employees="
               + this.employees
               + ", employeMap="
               + this.employeMap
               + "]";
    }


}
