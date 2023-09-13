package day32.Opencart.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/day32/Opencart/features/OpenCart.feature"},
        glue = {"day32/Opencart/steddefs"},
        dryRun = false
)
public class RunnerOpencart extends AbstractTestNGCucumberTests {


}
