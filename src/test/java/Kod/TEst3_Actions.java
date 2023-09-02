package Kod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class TEst3_Actions extends BaseTest {

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test2(){

        driver.get("https://demoqa.com/slider");

        By lSlide =By.xpath("//input[@class='range-slider range-slider--primary']");
        WebElement slide = driver.findElement(lSlide);
        WebElement value = driver.findElement(By.xpath("//input[@class='form-control']"));

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(slide)
                .moveByOffset(135 ,0)
                .release()
                .perform();



    }
}

