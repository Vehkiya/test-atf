package org.example.acceptance.config;

import org.example.core.configuration.BaseConfiguration;
import org.example.domain.config.ApiProfileConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BaseConfiguration.class,
        ApiProfileConfiguration.class})
@ComponentScan({"org.example.acceptance.actions",
        "org.example.acceptance.context"})
public class CucumberSpringConfig {
}
