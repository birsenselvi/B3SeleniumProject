package day35_runners_reports_isFailedScreenShots.reports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day35_runners_reports/features/Features.feature"},
        glue = {"day35_runners_reports_isFailedScreenShots/stepdefs"},
        plugin = {"pretty",
        "html:target/cucumber/cucumber.html",
        "json:target/cucumber/cucumber.json",
        "testng:target/cucumber/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunnerReport1 extends AbstractTestNGCucumberTests {

}
