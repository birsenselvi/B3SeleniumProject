package gun35_runners_reports.stepdefs;

import io.cucumber.java.en.Given;
import org.testng.Assert;

public class StepDefs35 {
    @Given("rr Scenario {int} Step {int}")
    public void rrScenarioStep(int scenario, int step) {
        System.out.println("Scenario " + scenario + " , Step " + step);
    }

    @Given("rr is {int} equals to {int}")
    public void rrIsEqualsTo(int num1, int num2) {
        Assert.assertEquals(num1, num2);
    }
}
