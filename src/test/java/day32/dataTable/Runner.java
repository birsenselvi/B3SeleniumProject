package day32.dataTable;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day32/dataTable/DataTables.feature"},
        glue = {"day32/dataTable"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
