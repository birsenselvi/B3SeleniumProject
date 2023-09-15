package gun35_runners_reports.reports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/main/java/gun35_runners_reports/features"},
        glue = {"gun35_runners_reports/stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
public class ExtentReport extends AbstractTestNGCucumberTests {
}
