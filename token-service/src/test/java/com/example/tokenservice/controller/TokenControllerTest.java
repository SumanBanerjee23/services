package com.example.tokenservice.controller;

import com.example.tokenservice.service.GeneratorService;
import com.example.tokenservice.service.ValidatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TokenController.class)
@AutoConfigureMockMvc
public class TokenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GeneratorService generatorService;

    @MockBean
    private ValidatorService validatorService;

    @Test
    public void testGenerateTokenEndpoint() throws Exception {
        String content = "{\n" +
                "  \"availableDigits\": [2, 4, 7, 9, 0]\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/token/generate")
                        .content(content)
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testValidateTokenEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/token/validate/" + "2249-4472-0279-9420")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

