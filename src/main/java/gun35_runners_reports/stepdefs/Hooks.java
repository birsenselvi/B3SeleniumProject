package gun35_runners_reports.stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {

    @AfterStep
    public void after(Scenario scenario){

        if (scenario.isFailed()){
            scenario.log(scenario.getName() + " failled");
            Driver.getDriver().get("https://google.com");
            TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
            byte[] resim = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(resim, "image/png", "Hata Resmi");
        }
    }
}
