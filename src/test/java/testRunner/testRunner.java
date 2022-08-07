package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:FeatureFiles/"}
        ,glue={"stepDefinition"},
        plugin ={"html:target/CucumberReports/cucumber-html-report.html","json:target/CucumberReports/cucumber-json-report.json",
                "junit:target/CucumberReports/cucumber-xml-report.xml"
                ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty"}
        ,monochrome = true
        ,tags=""
        //,publish = true

        //,dryRun = true
)public class testRunner {}
