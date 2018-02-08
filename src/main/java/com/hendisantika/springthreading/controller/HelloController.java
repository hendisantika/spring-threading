package com.hendisantika.springthreading.controller;

import com.hendisantika.springthreading.model.Employee;
import com.hendisantika.springthreading.repository.EmployeeRepository;
import com.hendisantika.springthreading.service.AsynchronousService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private AsynchronousService anAsynchronousService;

    @RequestMapping("/runTask")
    public String executeAsync() {

        anAsynchronousService.executeAsynchronously();

        return "OK";
    }

    @RequestMapping("/employees")
    public List<Employee> employees() throws Exception {

        return anAsynchronousService.fetchEmployess().get();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public void add(@RequestBody Employee employee) {

        employeeRepository.save(employee);
    }

}