package day34_hooks_scenarioOutLine.ScenarioOutline.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day34_hooks_scenarioOutLine/ScenarioOutline/features/ScenarioOutline1.feature"},
        glue = {"day34_hooks_scenarioOutLine/ScenarioOutline/stepdefs"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
