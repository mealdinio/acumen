package cucumber.featureRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(plugin = {"pretty", "html:target/cucumber"})

    public class ContactUsPageRunner {
    }

//    @Cucumber.(
//            format = {"pretty", "html:target/cucumber", "json:target/ContactUsPageRunner.json"},
//            features = {"src/test/java/cucumber/pages/ContactUsPage.feature"},
//            strict = true,
//            glue = {"classpath:cucumber"}
//    )

