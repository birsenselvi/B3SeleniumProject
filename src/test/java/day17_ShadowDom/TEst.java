package day17_ShadowDom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class TEst extends BaseTest {
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        By shadowRootElement = By.cssSelector("#content");
        WebElement P = driver
                .findElement(shadowRootElement)
                .getShadowRoot()
                .findElement(By.cssSelector("p"));
        String text = P.getText();
        System.out.println(text);
        driver.quit();
    }
    }

