package com.example.service;

import com.example.database.entity.Company;
import com.example.database.repos.CRUDRepository;
import com.example.dto.CompanyReadDTO;
import com.example.listener.entity.AccessType;
import com.example.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CRUDRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    public Optional<CompanyReadDTO> findById(Integer id) {
        return companyRepository.findById(id).map(e ->{
                eventPublisher.publishEvent(new EntityEvent(e, AccessType.CREATE));
                return new CompanyReadDTO(e.id());
        });
    }
}
