package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:/Assignment/RestAPIFramework/restassured-test/src/test/java/resources/ExchangeRates.feature",
        glue= {"stepDefinitions"},
        plugin={"pretty", "html:target/cucumber-reports"},
        dryRun = true
)
public class TestRunner {
}
//C:\\Assignment\\RestAPIFramework\\restassured-test\\