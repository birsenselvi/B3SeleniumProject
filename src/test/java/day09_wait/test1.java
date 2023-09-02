package day09_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class test1 {
    WebDriver driver;
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";

    @Test
    public void test_getRectColor(){
        driver = new ChromeDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement addBoxButton = driver.findElement(By.cssSelector("#adder"));
        addBoxButton.click();
        WebElement box = driver.findElement(By.cssSelector("div#box0.redbox"));
        String background_color = box.getCssValue("background-color");
        System.out.println(background_color);
        System.out.println(box.isDisplayed());


        driver.quit();

    }
    @Test
    public void test_sendKey(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20),Duration.ofMillis(300));
        driver.get(url);
        By lRevealButton = By.cssSelector("#reveal");
        By lReveal = By.cssSelector("#revealed");

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(lRevealButton).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lReveal));
        input.sendKeys("Selvi Coskun");



        driver.quit();

    }
}
