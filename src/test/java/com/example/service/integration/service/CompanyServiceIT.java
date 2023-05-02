package com.example.service.integration.service;

import com.example.ApplicationRunner;
import com.example.config.DatabaseProperties;
import com.example.database.entity.Company;
import com.example.dto.CompanyReadDTO;
import com.example.listener.entity.EntityEvent;
import com.example.service.CompanyService;
import com.example.service.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/*
Вместо этого @SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationRunner.class
,initializers = ConfigDataApplicationContextInitializer.class)*/
@IT
@RequiredArgsConstructor
/*
Вместо этого настройка в спринг.проперти
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
*/
public class CompanyServiceIT {
    public static final Integer COMPANY_ID = 1;
    @Autowired
    private final CompanyService companyService;
    @Autowired
    private final DatabaseProperties databaseProperties;
    @Test
    void findById() {
        Optional<CompanyReadDTO> actual = companyService.findById(COMPANY_ID);
        assertTrue(actual.isPresent());
        CompanyReadDTO expected = new CompanyReadDTO(COMPANY_ID);
        actual.ifPresent(act -> assertEquals(expected,act));

    }
}
