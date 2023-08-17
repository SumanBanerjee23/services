package com.example.tokenservice.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public boolean validateToken(String token) {
        token = token.replaceAll("-", "");
        char[] digits = token.toCharArray();

        int sum = 0;
        boolean alternate = false;

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(digits[i]);

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }
}
