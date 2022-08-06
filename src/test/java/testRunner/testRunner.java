package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:FeatureFiles/RCBValidations.feature"}
        ,glue={"stepDefinition"},
        plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty"}
        ,monochrome = true
        //,publish = true

        //,dryRun = true
)public class testRunner {}
