package gun34_hooks_scenarioOutline.scenarioOutline2.stepdefs;

import gun34_hooks_scenarioOutline.scenarioOutline2.runners.RunnerSd;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void before(){
        Driver.getDriver(RunnerSd.browsers.get());
    }

    @After
    public void after(){
        Driver.quit();
    }
}
