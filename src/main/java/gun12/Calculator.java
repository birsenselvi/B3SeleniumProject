package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Calculator {

    String url = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";
    WebDriver driver;
    WebDriverWait wait;

    By lScreen = By.cssSelector(".screen");

    Calculator(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void text_calculator(){

        driver.get(url);

        Random r = new Random();
        int num1 = 100 + r.nextInt(400);
        int num2 = 100 + r.nextInt(400);


        clickCalc(String.valueOf(num1));
        clickCalc("+");
        clickCalc(num2 + "");
        clickCalc("=");

        wait.until(ExpectedConditions.textToBe(lScreen, String.valueOf(num1 + num2)));

        driver.quit();


    }



    public void clickCalc(String num){
        for (int i = 0; i < num.length(); i++) {
            click(getNumber(num.substring(i, i+1)));
        }
    }


    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public By getNumber(String num){
        return By.xpath("//div[@class='keys']//span[text()='" + num +"']");
    }




}
