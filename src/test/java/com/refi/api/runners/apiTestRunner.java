package com.refi.api.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "com.refi.api.stepdef",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@api"
)

public class apiTestRunner {
}
