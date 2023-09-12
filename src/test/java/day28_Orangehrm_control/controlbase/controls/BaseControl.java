package day28_Orangehrm_control.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public abstract class BaseControl {

    protected WebDriver driver;
    protected static WebDriverWait wait;
    protected WebElement element;
    protected By locator;
    protected String label;

    protected BaseControl(By locator){
        this.locator = locator;
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void sendKeys(CharSequence...text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public WebElement getRootElement(){
        return element;
    }
}
