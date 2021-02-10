package atf.health;

import common.configuration.BaseConfiguration;
import common.properties.EnvironmentProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Verifies that spring context in ATF is healthy
 */
@Tag("health")
@SpringBootTest(classes = BaseConfiguration.class)
public class SpringContextHealthTest {

    @Autowired
    private EnvironmentProperties environmentProperties;

    @Test
    void verifyPropertiesAreLoaded() {
        Assertions.assertNotNull(environmentProperties);
        Assertions.assertNotNull(environmentProperties.getHost());
    }
}
