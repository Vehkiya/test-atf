package org.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/html-report/",
                "junit:target/junit-report/cucumber.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.example.steps",
                "org.example.acceptance.config"}
)
public class CucumberRunner {
}
