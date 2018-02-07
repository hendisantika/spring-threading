package com.hendisantika.springthreading.config;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-threading
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/02/18
 * Time: 06.53
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource createMainDataSource() {

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:" + System.getProperty("java.io.tmpdir") + "/testdata");
        return ds;
    }
}