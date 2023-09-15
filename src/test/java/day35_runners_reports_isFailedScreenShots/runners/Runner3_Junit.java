package day35_runners_reports_isFailedScreenShots.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // extends AbstractTestNGCucumberTests yerine
@CucumberOptions(
        features = {"src/test/java/day35_runners_reports/features/Features.feature"},
        glue = {"day35_runners_reports_isFailedScreenShots/stepdefs"}

)

public class Runner3_Junit {

}
