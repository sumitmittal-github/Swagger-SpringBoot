package com.sumit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class SwaggerConfig {

    private final String AUTH_SERVER = "<AUTH_SERVER>";
    private final String CLIENT_ID = "<CLIENT_ID>";
    private final String CLIENT_SECRET = "<CLIENT_SECRET>";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/person/*"))                                  //.paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.sumit.controller"))                   //.apis(RequestHandlerSelectors.any())
                .build()
                .securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "REST API Title",
                "REST API Description.",
                "Version : 1.0.0",
                "Terms of services",
                new Contact("Sumit Mittal", "https://www.linkedin.com/in/tech-sumit-mittal/", "sumitmittal.adonis@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    private SecurityScheme securityScheme() {
        return new OAuthBuilder()
                .name("spring_oauth")
                .grantTypes(Arrays.asList(grantType()))
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.regex("/foos.*"))
                .build();
    }

    private GrantType grantType(){
        return new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
                .tokenRequestEndpoint(new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
                .build();
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                new AuthorizationScope("foo", "Access foo API") };
        return scopes;
    }


}