package day18_tryCAtch;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static day18_tryCAtch.Locators.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class WaitAlternativ {
    WebDriver driver;
    WebDriverWait wait;


    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void test(){

        driver.get(url);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(input));

         wait.until(d->{
            try {
                if(d.findElement(Locators.input).isDisplayed())
                    return true;
                return false;
            }catch (Exception e){
                return false;
            }
        });
        /**
         *                                Fluent wait
         */

        wait.until(or(visibilityOfElementLocated(input),visibilityOfElementLocated(button)));

         Wait<WebDriver> wait1 = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(10))
                 .pollingEvery(Duration.ofMillis(300))
                 .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
        wait1.until(d->{
            try {
                if(d.findElement(Locators.input).isDisplayed())
                    return true;
                return false;
            }catch (Exception e){
                return false;
            }
        });

    }
    public void click(By locator){
        wait.until(d->{
            try {
                driver.findElement(locator).click();
                return true;
            }catch (Exception e){
                return false;
            }
        });
    }

}
class Locators{

    public static String url = "http://opencart.abstracta.us/";
    public static By input = By.cssSelector("#search input");
    public static By button = By.cssSelector("#search button");
}
