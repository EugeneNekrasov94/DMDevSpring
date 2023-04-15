package com.example.service;

import com.example.repos.CompanyRepository;

public class UserService {
    private final CompanyRepository companyRepository;

    public UserService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
