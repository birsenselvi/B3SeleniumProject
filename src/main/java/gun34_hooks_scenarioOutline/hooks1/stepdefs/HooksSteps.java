package gun34_hooks_scenarioOutline.hooks1.stepdefs;

import io.cucumber.java.en.Given;

public class HooksSteps {
    @Given("hooks scenario {int} step {int}")
    public void hooksScenarioStep(int scenario, int step) {
        System.out.println("Scenario " + scenario + ", Step " + step);
        //Assert.assertTrue(step<3);
    }

}
