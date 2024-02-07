package org.example.demomarketapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Here you get token to authorize")
public class JwtResponse {

    private final String token;
}
