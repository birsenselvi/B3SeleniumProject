package gun33_cucumber.tags.stepdefs;

import io.cucumber.java.en.Given;

public class MyStepdefs {
    @Given("tags scenario {int} step {int}")
    public void tagsScenarioStep(int scenario, int step) {
        System.out.println("Scenario " + scenario + ", step " + step);
    }
}
