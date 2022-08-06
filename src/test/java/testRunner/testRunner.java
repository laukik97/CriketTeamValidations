package testRunner;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/java/resources/FeatureFiles/*"
        ,glue={"stepDefinition"}
)public class testRunner {
}
