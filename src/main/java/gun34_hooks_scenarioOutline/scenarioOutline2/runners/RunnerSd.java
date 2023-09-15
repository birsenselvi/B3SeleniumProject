package gun34_hooks_scenarioOutline.scenarioOutline2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;

@CucumberOptions(
        features = {"src/main/java/gun34_hooks_scenarioOutline/scenarioOutline2/features"},
        glue = {"gun34_hooks_scenarioOutline/scenarioOutline2/stepdefs"},
        plugin = {"pretty",             // console output icin
                "json:target/cucumber/cucumber.json",   // test sonuclarini json olarak kaydeder
                "html:target/cucumber/cucumber.html"    // test sonuclarini html olarak kaydeder
        }
)
public class RunnerSd extends AbstractTestNGCucumberTests {
        public static ThreadLocal<String> browsers = new ThreadLocal<>();

        @BeforeTest
        @Parameters("browser")
        public void beforeTest(@Optional("chrome") String browser){
                Driver.getDriver(browser);
                browsers.set(browser);
        }
}


/*
        Runner ile
        1. TestNG/JUnit
        2. Cucumber
 */