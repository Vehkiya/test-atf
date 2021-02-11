package org.example.config;

import org.example.configuration.BaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BaseConfiguration.class,
        ApiProfileConfiguration.class})
@ComponentScan({"org.example.actions",
        "org.example.context"})
public class CucumberSpringConfig {
}
