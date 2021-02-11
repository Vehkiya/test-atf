package org.example.atf.health;

import org.example.configuration.BaseConfiguration;
import org.example.properties.EnvironmentProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Verifies that spring org.example.context in ATF is healthy
 */
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
