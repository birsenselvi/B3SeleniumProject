package day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.runnerTEkCesitrBrowserda;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;

@CucumberOptions(
features = {"src/test/java/day34_hooks_scenarioOutLine/scenarioOutline2TheradLocal/features/DEmoFEature.feature"},
        glue = {"day34_hooks_scenarioOutLine/scenarioOutline2TheradLocal/stepdefs"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json",
        "html:target/cucumber/cucumber.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

   public static  ThreadLocal<String> browsers = new ThreadLocal<>();
    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("Chrome") String browser){
      Driver.getDriver(browser);
        browsers.set(browser);
    }
}
