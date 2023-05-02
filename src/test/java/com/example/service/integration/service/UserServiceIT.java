package com.example.service.integration.service;

import com.example.beanPostProcessor.Transaction;
import com.example.database.pools.ConnectionPool;
import com.example.service.UserService;
import com.example.service.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool;

    @Test
    public void test() {
        System.out.println();
    }
}
