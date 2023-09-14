package gun34_hooks_scenarioOutline.hooks2.stepdefs;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void before1(Scenario scenario){
        System.out.println(scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
    }

    // her step sonrasi run olur
    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println(scenario.getUri());
        if (scenario.isFailed()){
            // screenshot
        }
    }

    @After
    public void after1(Scenario scenario){
        System.out.println("scenario.getLine() = " + scenario.getLine());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());
        if (scenario.isFailed()){

        }
    }

}
