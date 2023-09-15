package gun34_hooks_scenarioOutline.hooks2.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/main/java/gun34_cucumber_hooks/test2/features"},
        glue = {"gun34_hooks_scenarioOutline/hooks2/stepdefs"},
        tags = "@smoke"
        //plugin = {"pretty"}

)
public class RunnerHooks2 extends AbstractTestNGCucumberTests {

}
