package gun34_hooks_scenarioOutline.test1.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        features = {"src/main/java/gun34_cucumber_hooks/test1/features"},
        glue = {"gun34_hooks_scenarioOutline/test1/stepdefs"}
        //plugin = {"pretty"}

)
public class RunnerHooks1 extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeTest(){
        System.out.println("TestNG before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("TestNG After Test");
    }
}
