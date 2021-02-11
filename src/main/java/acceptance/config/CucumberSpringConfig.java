package acceptance.config;

import common.configuration.BaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BaseConfiguration.class})
@ComponentScan({"acceptance.actions",
        "acceptance.context"})
public class CucumberSpringConfig {
}
