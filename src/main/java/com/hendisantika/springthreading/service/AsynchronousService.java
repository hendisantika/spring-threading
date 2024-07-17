package com.hendisantika.springthreading.service;

import com.hendisantika.springthreading.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-threading
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/18
 * Time: 07.01
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AsynchronousService {

    private final TaskExecutor taskExecutor;

    private final ApplicationContext applicationContext;

    @PersistenceContext
    private EntityManager entityManager;

    @Async
    @Transactional
    public void printEmployees() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
        employees.stream().forEach(e -> System.out.println(e.getEmail()));
    }

    @Async("specificTaskExecutor")
    @Transactional
    public CompletableFuture<List<Employee>> fetchEmployees() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
        return CompletableFuture.completedFuture(employees);
    }


    public void executeAsynchronously() {
        MyThread myThread = applicationContext.getBean(MyThread.class);
        taskExecutor.execute(myThread);
    }

}
