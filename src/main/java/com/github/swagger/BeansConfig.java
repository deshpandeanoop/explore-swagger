package com.github.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class BeansConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.swagger"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Persons API",
                "Sample API for exploring Swagger",
                "1.0",
                "Free to use",
                new Contact("John Doe", "https://www.youtube.com/watch?v=8s9I1G4tXhA", "abc@gmail.com"),
                "API License",
                "http://www.apache.org/",
                Collections.emptyList()
        );
    }
}