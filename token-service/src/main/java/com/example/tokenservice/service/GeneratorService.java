package com.example.tokenservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// GeneratorService
@Service
public class GeneratorService {
    public String generateToken(List<Integer> availableDigits) {
        List<Integer> tokenDigits = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            tokenDigits.add(availableDigits.get(new Random().nextInt(availableDigits.size())));
        }
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 16; i += 4) {
            token.append(tokenDigits.get(i)).append(tokenDigits.get(i + 1))
                    .append(tokenDigits.get(i + 2)).append(tokenDigits.get(i + 3))
                    .append("-");
        }
        return token.substring(0, token.length() - 1);
    }
}

