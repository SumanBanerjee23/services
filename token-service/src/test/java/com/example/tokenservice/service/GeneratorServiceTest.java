package com.example.tokenservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GeneratorServiceTest {

    @Autowired
    private GeneratorService generatorService;

    @Test
    public void testGenerateToken() {
        // Test available digits: 2, 4, 7, 9, 0
        String token = generatorService.generateToken(List.of(2, 4, 7, 9, 0));
        assertTrue(token.matches("[24790]{4}-[24790]{4}-[24790]{4}-[24790]{4}"));
    }
}

