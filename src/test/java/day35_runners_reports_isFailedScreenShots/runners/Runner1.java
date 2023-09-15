package day35_runners_reports_isFailedScreenShots.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day35_runners_reports/features/Features.feature"},
        glue = {"day35_runners_reports_isFailedScreenShots/stepdefs"},
        monochrome = false, // consol output unun renkli yada monocrom olmasi
        dryRun = false, // steplerin düzenli tanimlanmis mi kontrol eder
        publish = false, //rapor yazma
        plugin = {"pretty",
        "html:target/cucumber/cucumber.html",
        "json:target/cucumber/cucumber.json",
        "testng:target/cucumber/cucumber.xml"}
)

public class Runner1 extends AbstractTestNGCucumberTests {

}
