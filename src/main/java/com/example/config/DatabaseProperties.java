package com.example.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@ConstructorBinding
@Value
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    String username;
    String password;
    PoolProperties pool;
    String driver;
    String url;
    String hosts;
    String usernameTest;
    List<PoolProperties> pools;
    Map<String,Object> properties;
    @Value
    public static class PoolProperties {
        Integer size;
        Integer timeout;
    }





}
