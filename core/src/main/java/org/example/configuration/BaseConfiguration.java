package org.example.configuration;

import org.example.properties.EnvironmentProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootConfiguration
@EnableConfigurationProperties({EnvironmentProperties.class})
public class BaseConfiguration {
}