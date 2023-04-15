package com.example.repos;

import com.example.beanPostProcessor.InjectBean;
import com.example.beanPostProcessor.Transaction;
import com.example.beanPostProcessor.TransactionBeanPostProcessor;
import com.example.entity.Company;
import com.example.pools.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Log4j2
@Transaction
public class CompanyRepository implements CRUDRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

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
