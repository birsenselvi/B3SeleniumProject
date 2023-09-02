package day15_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class text extends BaseTest {
    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url = "https://demoqa.com/auto-complete";
    @Test
    public void test1(){

        driver.get(url);
        By lInput = By.cssSelector("#autoCompleteMultipleContainer>div");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lInput));
        new Actions(driver)
                .click(input)
                .pause(500)
                .keyDown(Keys.SHIFT)
                .pause(500)
                .keyDown("g")
                .pause(500)
                .keyUp(Keys.SHIFT)
                .pause(500)
                .keyDown(Keys.ARROW_DOWN)
                .pause(500)
                .sendKeys(Keys.ENTER)
                .pause(500)
                .build()
                .perform();





    }
}
