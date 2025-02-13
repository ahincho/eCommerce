package com.brecom.ecommerce.commons.infrastructure.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addTagsItem(new Tag()
                        .name("Orders")
                        .description("Functional endpoints for managing orders"))
                .info(new Info()
                        .title("Brecom - eCommerce Monolith - Restful API")
                        .version("1.0")
                        .description("Detailed API documentation for eCommerce Monolith")
                        .contact(new Contact()
                                .name("Angel Hincho")
                                .email("ahincho@unsa.edu.pe")
                                .url("https://github.com/ahincho"))
                        .termsOfService("https://github.com/ahincho/eCommerce")
                );
    }
}
