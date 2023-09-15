package day35_runners_reports_isFailedScreenShots.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day35_runners_reports/features/Features.feature"},
        glue = {"day35_runners_reports_isFailedScreenShots/stepdefs"},
        plugin = {"pretty",
        "html:target/cucumber/cucumber.html",
        "json:target/cucumber/cucumber.json",
        "testng:target/cucumber/cucumber.xml"}
)

public class Runner2_SystemProperty extends AbstractTestNGCucumberTests {
    {
        System.setProperty("cucumber.publish.quite", "true");
        System.setProperty("cucumber.features", "src/test/java/day35_runners_reports/features/Features.feature");
    }
}
