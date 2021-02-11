package com.example.au.couchbasedemo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        Set<String> responseProduceType = new HashSet<String>();
        responseProduceType.add("application/json");
        responseProduceType.add("application/xml");
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class)
                .produces(responseProduceType)
                .consumes(responseProduceType)
                
                .apiInfo(apiInfo());
                
                
    }
    private ApiInfo apiInfo() {
        @SuppressWarnings("deprecation")
        ApiInfo apiInfo = new ApiInfo(
                "Item REST API",
                "All Item related information",
                "API",
                "Terms of services",
                "abhisek.nandan@accolitedigital.com",
                "License of API",
                "API License URL");
        return apiInfo;
    }
    private Object apiKey() {
        return null;
    }
}
