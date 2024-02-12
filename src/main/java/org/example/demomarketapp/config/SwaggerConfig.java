package org.example.demomarketapp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //JUL (Java util logging) default lib
    //log4j (log4j1.xx(outdated) && log4j2.xx)
    //logback
    //slf4j -> wrapper

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key", getSecuritySchemesItem()))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"));
    }

    private SecurityScheme getSecuritySchemesItem() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }
}
