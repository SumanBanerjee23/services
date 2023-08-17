package com.example.tokenservice.model;

import lombok.Data;

import java.util.List;

@Data
public class TokenRequest {

    List<Integer> availableDigits;

}
