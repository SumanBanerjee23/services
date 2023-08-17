package com.example.tokenservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ValidatorServiceTest {

    @Autowired
    private ValidatorService validatorService;


    @Test
    public void testValidateInvalidToken() {
        boolean isValid = validatorService.validateToken("1234-5678-9012-3456");
        assertFalse(isValid);
    }
}
