package gun28_files_scenario.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BaseControl {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By locator;
    protected String label;

    protected BaseControl(By locator){
        this.locator = locator;

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
