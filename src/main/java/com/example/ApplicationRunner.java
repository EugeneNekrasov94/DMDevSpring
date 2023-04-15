package com.example;

import com.example.pools.ConnectionPool;
import com.example.repos.CRUDRepository;
import com.example.repos.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        CRUDRepository companyRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
            ConnectionPool bean = context.getBean("pool1", ConnectionPool.class);
            System.out.println(bean);
            companyRepository = context.getBean("companyRepository", CRUDRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
