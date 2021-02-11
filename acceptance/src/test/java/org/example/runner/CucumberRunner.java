package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = {"src/test/resources/acceptance/test/"},
        glue = {"org.example.steps",
                "org.example.config"}
)
public class CucumberRunner {
}
