package com.hendisantika.springthreading.controller;

import com.hendisantika.springthreading.model.Employee;
import com.hendisantika.springthreading.repository.EmployeeRepository;
import com.hendisantika.springthreading.service.AsynchronousService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-threading
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/18
 * Time: 07.04
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final EmployeeRepository employeeRepository;
    private final AsynchronousService anAsynchronousService;

    @GetMapping("/runTask")
    public String executeAsync() {
        anAsynchronousService.executeAsynchronously();
        return "OK";
    }

    @GetMapping("/employees")
    public List<Employee> employees() throws Exception {
        return anAsynchronousService.fetchEmployees().get();
    }

    @PostMapping(value = "/employee")
    public void add(@RequestBody Employee employee) {
        employeeRepository.save(employee);
    }

}
