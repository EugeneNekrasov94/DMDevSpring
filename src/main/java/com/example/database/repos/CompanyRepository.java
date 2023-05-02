package com.example.database.repos;

import com.example.beanPostProcessor.Auditing;
import com.example.beanPostProcessor.Transaction;
import com.example.database.entity.Company;
import com.example.database.pools.ConnectionPool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.boot.spi.Bootstrap;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Optional;

@Transaction
@Auditing
@Repository
@RequiredArgsConstructor
@Slf4j
public class CompanyRepository implements CRUDRepository<Integer, Company> {
    @Qualifier(value = "pool2")
    private final ConnectionPool connectionPool;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("init company repository!!!");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("findById method!!!");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        log.info("delete method!!!");
    }
}
