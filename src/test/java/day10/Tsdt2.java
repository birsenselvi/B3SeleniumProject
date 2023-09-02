package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tsdt2 {
    WebDriver driver;
    String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
    @Test
    public void clickBottons(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
       /* By lbuttonOne = By.cssSelector("#button00");
        By lbuttonTwo = By.cssSelector("#button01");
        By lbuttonThree = By.cssSelector("#button02");
        By lbuttonFour = By.cssSelector("#button03");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lbuttonOne)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbuttonTwo)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbuttonThree)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbuttonFour)).click();

        driver.quit();
*/
        By[] locators = {
                By.cssSelector("button00"),
                By.cssSelector("button01"),
                By.cssSelector("button02"),
                By.cssSelector("button03")
        };
        for (int i = 0; i < locators.length; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(locators[i])).click();

        }

        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");
    }
}
