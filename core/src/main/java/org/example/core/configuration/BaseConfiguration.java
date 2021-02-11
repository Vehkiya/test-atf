package org.example.core.configuration;

import org.example.core.properties.EnvironmentProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootConfiguration
@EnableConfigurationProperties({EnvironmentProperties.class})
public class BaseConfiguration {
}