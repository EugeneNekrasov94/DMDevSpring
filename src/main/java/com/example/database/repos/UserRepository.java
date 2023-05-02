package com.example.database.repos;

import com.example.database.pools.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Qualifier(value = "pool2")
    private final ConnectionPool connectionPool;

}
