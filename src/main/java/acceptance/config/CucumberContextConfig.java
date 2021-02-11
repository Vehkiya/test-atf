package acceptance.config;

import common.properties.EnvironmentProperties;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CucumberSpringConfig.class)
@CucumberContextConfiguration
@EnableConfigurationProperties({EnvironmentProperties.class})
public class CucumberContextConfig {

}
