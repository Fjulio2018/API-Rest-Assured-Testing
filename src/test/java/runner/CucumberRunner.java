package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.cat.bdd.api.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "not @skips"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}