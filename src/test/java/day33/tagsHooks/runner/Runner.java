package day33.tagsHooks.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day33/tagsHooks/feature/Tags/Tags.feature"},
        glue = {"day33/tagsHooks/stepdefs"},
        tags = "@smoke or @temp"
)
public class Runner extends AbstractTestNGCucumberTests {
}
