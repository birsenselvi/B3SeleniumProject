package gun32_cucumber.variables;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/main/java/gun32_cucumber/variables/Gherkin.feature"},
        glue = {"gun32_cucumber/variables"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
