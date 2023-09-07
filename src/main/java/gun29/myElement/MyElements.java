package gun29.myElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class MyElements {


    public static void open(String url){

        Driver.getDriver(DriverConfig.browser);
        String size = DriverConfig.size;
        int width = Integer.parseInt(size.trim().split("x")[0]);
        int height = Integer.parseInt(size.trim().split("x")[1]);
        Driver.getDriver().manage().window().setSize(new Dimension(width, height));
        Driver.getDriver().get(url);
    }
    public static MyElements $(By locator) {
        return new MyElements(locator);
    }

    private WebDriver driver;
    private WebDriverWait wait;
    private By locator;

    private MyElements(By locator) {
        this.locator = locator;
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MyElements shouldBe(Conditions condition) {

        switch (condition) {
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            default:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        return this;
    }

    public MyElements sendKey(String text) {
        driver.findElement(locator).sendKeys(text);
        return this;
    }

    public void click() {
        driver.findElement(locator).click();
    }

    public MyElements hover(){
        new Actions(driver)
                .moveToElement(driver.findElement(locator))
                .perform();
        return this;
    }

}
