package com.example;

import com.example.pools.ConnectionPool;
import com.example.repos.UserRepository;
import com.example.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        UserRepository userRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
            ConnectionPool bean = context.getBean("pool1", ConnectionPool.class);
            System.out.println(bean);
            userRepository = context.getBean("userRepository", UserRepository.class);
            System.out.println(userRepository);
        }
    }
}
