package day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.stepdefs;


import day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.runnerTEkCesitrBrowserda.Runner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {
    @Before
    public void before(){
        Driver.getDriver(Runner.browsers.get());
    }
    @After
    public void after(){
        Driver.quit();
    }
}
