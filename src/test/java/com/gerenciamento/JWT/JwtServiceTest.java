package com.gerenciamento.JWT;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JwtServiceTest {

    JwtService jwtService = new JwtService();

    @Test
    void deveExtrairEmailDoToken() throws Exception{
        String token = jwtService.generateToken("joao@email.com");
        assertThat(jwtService.extractEmail(token)).isEqualTo("joao@email.com");
    }

}