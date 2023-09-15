package day35_runners_reports_isFailedScreenShots.stepdefs;

import io.cucumber.java.en.Given;
import org.testng.Assert;

public class StepDefs {
    @Given("rr Scenario {int} Step {int}")
    public void rrScenarioStep(int scenario, int step) {
        System.out.println("Scenario " + scenario + " , Step " + step);
    }

    @Given("rr is {int} equals {int}")
    public void rrIsEquals(int num1, int num2) {

        Assert.assertEquals(num1, num2);
    }
}
