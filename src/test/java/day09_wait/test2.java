package day09_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class test2 {
    WebDriver driver;
    String url =" https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
    @Test
    public void test_sendKey(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20),Duration.ofMillis(300));
        driver.get(url);
        By lText = By.cssSelector("p#text.lead");
        By imgs = By.cssSelector("#image-container img");
        By lEnd = By.cssSelector("img#landscape");
        //wait.until(ExpectedConditions.textToBe(lText,"Done!"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lEnd));
        wait.until(ExpectedConditions.numberOfElementsToBe(imgs,4));
        List<WebElement> images = wait.until(ExpectedConditions.numberOfElementsToBe(imgs,4));
        for (WebElement element : images) {
            System.out.println(element.getAttribute("alt"));

        }




        driver.quit();

    }
}
