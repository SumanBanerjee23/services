package com.example.tokenservice.controller;

import com.example.tokenservice.model.TokenRequest;
import com.example.tokenservice.service.GeneratorService;
import com.example.tokenservice.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private ValidatorService validatorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestBody TokenRequest tokenRequest) {
        String token = generatorService.generateToken(tokenRequest.getAvailableDigits());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable String token) {
        boolean isValid = validatorService.validateToken(token);
        return ResponseEntity.ok(isValid);
    }
}

