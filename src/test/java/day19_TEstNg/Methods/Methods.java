package day19_TEstNg.Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;

    public Methods(Browsers browsers) {

        switch (browsers) {
            case Safari:
                driver = new SafariDriver();
                break;
            case Edge:
                driver = new EdgeDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void get(String url) {

        driver.get(url);
        get(url, " ");

    }

    public void get(String url, String title) {

        driver.get(url);

        if (title.length() > 0) {
            Assert.assertTrue(driver.getTitle().contains(title));
        }

    }

    public void click(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void click(By locator) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);

        // wait.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public void clickAlternativ(WebElement element) {

        try {

            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        } catch (Exception e) {

            try {
                new Actions(driver)
                        .click(element)
                        .perform();
            } catch (Exception e1) {

                try {

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", element);

                } catch (Exception e2) {

                    throw new RuntimeException("Element not clickable");
                }
            }
        }
    }

    public void sendKey(By locator, String name) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKey(element, name);
    }

    public void sendKey(WebElement element, String name) {

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(name);

    }

    public void hover(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));

        new Actions(driver)
                .moveToElement(element)
                .perform();

    }

    public void hover(By locator){

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        hover(element);

    }



}
