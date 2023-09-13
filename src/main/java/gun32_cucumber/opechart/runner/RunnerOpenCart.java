package gun32_cucumber.opechart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.io.File;

@CucumberOptions(

        // feature dosyalarinin yolu, content rootdan baslar
        features = {"src/main/java/gun32_cucumber/opechart/features"},

        // stepdefs yolu, source rootdan baslar
        glue = {"gun32_cucumber/opechart/stepdefs"},

        // true ise sadece featuredeki steplerin tanimlanip
        // tanimalanmadigini kontrol eder. Stepleri run etmez
        dryRun = false
)
public class RunnerOpenCart extends AbstractTestNGCucumberTests {


}
