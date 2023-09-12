package day31_testNg_cucumber.cucumber._02Definition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/test/java/day31_testNg_cucumber/cucumber/_02Definition/Definition2.feature"},
        glue = {"day31_testNg_cucumber/cucumber/stepdefs"},
        plugin = {"pretty"}
)

public class Runner2 extends AbstractTestNGCucumberTests {
}
