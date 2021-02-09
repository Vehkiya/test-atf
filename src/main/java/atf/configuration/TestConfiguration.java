package atf.configuration;

import atf.properties.EnvironmentProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import(ApiProfileConfiguration.class)
@EnableConfigurationProperties({EnvironmentProperties.class})
public class TestConfiguration {
}