package day35_runners_reports_isFailedScreenShots.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {
    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            scenario.log(scenario.getName() + " failed");
            TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
            Driver.getDriver().get("https://www.google.com");
            byte[] resim = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(resim, "image/png", "Hata Resmi");
        }

    }
}
