package gun18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static gun18.Locators.*;


public class WaitAlternative {

    WebDriver driver;
    WebDriverWait wait;

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void test1() {

        driver.get(url);

        wait.until(visibilityOfElementLocated(input));

        wait.until(d -> {
            try {
                if (d.findElement(Locators.input).isDisplayed())
                    return true;
                return false;
            } catch (Exception e) {
                return false;
            }
        });

        wait.until(or(
                visibilityOfElementLocated(input),
                visibilityOfElementLocated(button))
        );

    }


    public void click(By locator) {
        wait.until(d -> {
            try {
                driver.findElement(locator).click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void click1(By locator) {
        wait.until(d -> {
            try {
                driver.findElement(locator).click();
                return true;
            } catch (Exception e) {
                try {
                    new Actions(d)
                            .click(driver.findElement(locator))
                            .perform();
                    return true;
                }catch (Exception e2){
                    return false;
                }
            }
        });
    }

}

class Locators {

    public static String url = "http://opencart.abstracta.us/";
    public static By input = By.cssSelector("#search input");
    public static By button = By.cssSelector("#search button");
}

