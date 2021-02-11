package org.example.config;

import io.restassured.RestAssured;
import org.example.properties.EnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("api")
@Configuration
@ComponentScan("org.example.service.api")
public class ApiProfileConfiguration {

    @Autowired
    private EnvironmentProperties environmentProperties;

    @PostConstruct
    private void setBaseUri() {
        RestAssured.baseURI = environmentProperties.getHost();
    }
}
