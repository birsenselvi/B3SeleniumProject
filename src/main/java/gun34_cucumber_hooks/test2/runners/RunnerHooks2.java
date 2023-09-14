package gun34_cucumber_hooks.test2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        features = {"src/main/java/gun34_cucumber_hooks/test2/features"},
        glue = {"gun34_cucumber_hooks/test2/stepdefs"},
        tags = "@smoke"
        //plugin = {"pretty"}

)
public class RunnerHooks2 extends AbstractTestNGCucumberTests {

}
