package com.hendisantika.springthreading.repository;

import com.hendisantika.springthreading.model.Employee;
import org.springframework.data.repository.CrudRepository;

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
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}