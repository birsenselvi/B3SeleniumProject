package day33.listFeature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day33/DaTabels.feature"},
        glue = {"day33"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
