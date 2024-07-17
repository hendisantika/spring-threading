package com.hendisantika.springthreading.config;

import com.hendisantika.springthreading.service.AsynchronousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-threading
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/18
 * Time: 07.03
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Scheduler {

    @Autowired
    private AsynchronousService checkAsyncService;

    @Scheduled(fixedDelay = 10000)
    public void checkTheSchedule() {
        checkAsyncService.printEmployees();
    }

}
