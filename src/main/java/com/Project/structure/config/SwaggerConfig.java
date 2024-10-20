package com.Project.structure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api-v1")
                .pathsToMatch("/**")
                .build();
    }
}
