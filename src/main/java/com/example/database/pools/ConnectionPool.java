package com.example.database.pools;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "pool")
@RequiredArgsConstructor
@Slf4j
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    //private Map<String, Object> properties;


    @PostConstruct
    private void init() {
        log.info("Initializing Cpool");
    }

    @PreDestroy
    private void destroy() {
        log.info("Clean Cpool");
    }
}
