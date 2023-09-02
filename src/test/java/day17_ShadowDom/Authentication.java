package day17_ShadowDom;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class Authentication extends BaseTest {
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url = "https://the-internet.herokuapp.com/";
    @Test
    public void test(){
        driver.get(url);
        By basicAuth = By.linkText("Basic Auth");
        driver.findElement(basicAuth).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));
        // acilan popup alert degildir. hata verir.
        driver.switchTo().alert().sendKeys("sss");
    }
    @Test
    public void test1(){
        driver.get(url);
        String name = "admin";
        String password = "admin";
        By DigestAut = By.linkText("Digest Authentication");
        driver.findElement(DigestAut).click();
        wait.until(ExpectedConditions.urlContains("digest_auth"));

        String url1 = driver.getCurrentUrl()
                .replace("https://", "https://" + name + ":" + password+"@" );

       // driver.get(url1);

        driver.navigate().to(url1);
        sleep(2000);
        driver.navigate().forward();
        sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
        sleep(2000);
        driver.navigate().refresh();
        sleep(2000);



        //driver.quit();

    }
}

