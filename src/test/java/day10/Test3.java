package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test3 {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";

    By lScreen = By.cssSelector(".screen");
    Test3(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void calculator(){

        clickCalc("2");
        clickCalc("+");
        clickCalc("2");
        clickCalc("=");

        wait.until(ExpectedConditions.textToBe(lScreen,"4"));

        driver.quit();
    }
    public void clickCalc(String num){
        click(getNumber(num));
    }
    public void click(By locator){

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
    public By getNumber(String num){
        return By.xpath("//div[@class='keys']//span[text() = '"+ num +"']");
    }
}
