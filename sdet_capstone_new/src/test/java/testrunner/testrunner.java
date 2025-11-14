package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {
        "src/test/resources/features",
    },
    glue = {"stepdefinitions","hooks"},
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-report.html"},
    tags = "@Payment",
    monochrome = true
)
public class testrunner extends AbstractTestNGCucumberTests {
	
}