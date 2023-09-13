package day33.tagsHooks.stepdefs;

import io.cucumber.java.en.When;

public class MyStepdefs {
    @When("tags scenario {int} step {int}")
    public void tagsScenarioStep(int scenario, int step) {
        System.out.println("Scenario " + scenario + ", step " + step );
        System.out.println("===========================================");
    }
}
