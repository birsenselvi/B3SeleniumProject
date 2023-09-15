package gun35_runners_reports.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/gun35_runners_reports/features"},
        glue = {"gun35_runners_reports/stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml"
        }

)
public class Runner3_JUnit {
}
