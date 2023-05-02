package com.example.config;

import com.example.database.pools.ConnectionPool;
import com.example.database.repos.CRUDRepository;
import com.example.database.repos.UserRepository;
import com.example.web.config.WebConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@Import(WebConfig.class)
public class ApplicationConfig {
    @Bean
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 13);
    }

    @Bean
    public ConnectionPool pool3(@Value("${db.usernameTest}") String username) {
        return new ConnectionPool(username, 777);
    }

    @Bean
    @Profile(value = "prod")
    public UserRepository userRepository2(ConnectionPool pool2) {
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3() {
        return new UserRepository(pool3("SSSSSS"));
    }
}
