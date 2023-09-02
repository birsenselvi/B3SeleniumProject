package day20_FindBy.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BAsePAge {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected BAsePAge(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }
    public void assertLogin(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
