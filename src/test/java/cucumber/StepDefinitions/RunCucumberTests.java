package cucumber.StepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"html:target/cucumberHtmlReport"},
            //pretty:target/cucumber-json-report.json
            features = "classpath:cucumber"
    )

    public class RunCucumberTests {
    }

