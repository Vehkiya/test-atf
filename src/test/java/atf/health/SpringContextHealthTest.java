package atf.health;

import atf.configuration.TestConfiguration;
import atf.properties.EnvironmentProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Tag("health")
@SpringBootTest(classes = TestConfiguration.class)
public class SpringContextHealthTest {

    @Autowired
    private EnvironmentProperties environmentProperties;

    @Test
    void verifyPropertiesAreLoaded() {
        Assertions.assertNotNull(environmentProperties);
        Assertions.assertNotNull(environmentProperties.getHost());
    }
}
