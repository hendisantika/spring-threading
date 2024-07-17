package com.hendisantika.springthreading.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-threading
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/18
 * Time: 07.02
 * To change this template use File | Settings | File Templates.
 */
@Component
@Scope("prototype")
public class MyThread implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        LOGGER.info("Called from thread");
    }
}
