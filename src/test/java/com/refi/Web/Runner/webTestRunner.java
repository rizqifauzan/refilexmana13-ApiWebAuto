package com.refi.Web.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "com.refi.Web.StepDef",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@Web"
)

public class webTestRunner {
}
