package br.com.matheus.bandeira.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().components(
                new Components()
        ).info(
                new Info()
                        .title("API Usuários - Matheus Bandeira")
                        .description("API Spring Boot para controle de usuários.")
        );
    }
}
