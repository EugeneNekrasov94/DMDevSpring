package com.example.service;

import com.example.database.entity.Company;
import com.example.database.repos.CRUDRepository;
import com.example.database.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CRUDRepository<Integer, Company> companyRepository;
}
