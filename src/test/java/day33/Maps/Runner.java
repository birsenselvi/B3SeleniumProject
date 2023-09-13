package day33.Maps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/day33/Maps/Maps.feature"}, glue = {"day33/Maps"})

public class Runner extends AbstractTestNGCucumberTests {
}
