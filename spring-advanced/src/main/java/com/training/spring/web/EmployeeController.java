package com.training.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.spring.Employee;
import com.training.spring.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee/provision")
// @RequestScope
// @SessionScope
// @ApplicationScope
public class EmployeeController {

    @Autowired
    WebCounterBean          counterBean;

    private long            counter = 0;

    @Autowired
    private EmployeeService es;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Employee employeeParam) {
        this.counterBean.increase();
        return "Counter : " + this.counterBean.getCounter() + " local Counter : " + ++this.counter;
    }

    @GetMapping("/get")
    public String get() {
        this.counterBean.increase();
        return "Counter : " + this.counterBean.getCounter() + " local Counter : " + ++this.counter;
    }


}
