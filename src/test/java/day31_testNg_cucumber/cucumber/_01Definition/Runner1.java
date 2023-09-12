package day31_testNg_cucumber.cucumber._01Definition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// cucumber in feature, stepdefs, plugins gibi özelliklerinin tanimlandigi yerdir.

@CucumberOptions(

        features = {"src/test/java/day31_testNg_cucumber/cucumber_01Definition/MyFirstFeature.feature"},// roottan baslar
        glue = {"day31_testNg_cucumber/cucumber/stepdefs"}//java dan alinir

)

public class Runner1 extends AbstractTestNGCucumberTests {


}
