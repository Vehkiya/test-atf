package atf.configuration;

import atf.properties.EnvironmentProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(
        EnvironmentProperties.class
)
@SpringBootConfiguration
public class TestConfiguration {
}
