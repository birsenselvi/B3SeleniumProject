package gun34_hooks_scenarioOutline.scenarioOutline.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/main/java/gun34_hooks_scenarioOutline/scenarioOutline/features"},
        glue = {"gun34_hooks_scenarioOutline/scenarioOutline/stepdefs"},
        tags = "@so2"
)
public class RunnerSO1 extends AbstractTestNGCucumberTests {
}
