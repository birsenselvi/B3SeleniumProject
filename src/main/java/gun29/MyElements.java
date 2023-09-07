package gun29;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class MyElements {

    public static MyElements $(By locator){
        return new MyElements(locator);
    }

    private WebDriver driver;
    private WebDriverWait wait;
    private By locator;

    private MyElements(By locator){
        this.locator = locator;
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MyElements sendKey(String text){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        return this;
    }

    public void click(){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}
