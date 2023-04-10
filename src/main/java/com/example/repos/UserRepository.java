package com.example.repos;

import com.example.beanPostProcessor.InjectBean;
import com.example.pools.ConnectionPool;

public class UserRepository {
    @InjectBean
    private ConnectionPool connectionPool;


}
