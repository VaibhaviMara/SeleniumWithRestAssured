package Swagger.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Learn\\Selenium\\restAssuredPetStore\\src\\test\\java\\Swagger\\resources\\SwaggerUsernamePasswordExtraction.feature",
glue = {"Swagger"},
plugin = {"pretty",                                                 // Makes console output readable
        "html:target/cucumber-reports/cucumber.html",             // Generates standard HTML report
        "json:target/cucumber-reports/cucumber.json",             // Generates JSON data for advanced reporting
        "junit:target/cucumber-reports/cucumber.xml",             // Generates JUnit XML report for CI/CD tools
        "rerun:target/failed_scenarios.txt"                       // Saves paths of failed tests for re-running
})

public class Runner extends AbstractTestNGCucumberTests {
}
