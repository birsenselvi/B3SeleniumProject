package day13_WindowsGecisleri_SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class test1 extends gun05_selenium.BaseClass {
    @Test
    public void testt(){

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/nestedframes");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String lframe = "frame1";
        driver.switchTo().frame(lframe);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector(".main-header")));
        driver.quit();



    }
    @Test
    public void testt1(){
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By lButton = By.cssSelector("button[aria-label='Bold']");
        By lIframeBody = By.id("tinymce");

        driver.findElement(lButton).click();

        driver.switchTo().frame(0);

        driver.findElement(lIframeBody).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        //driver.findElement(lIframeBody).sendKeys(Keys.DELETE);

        driver.findElement(lIframeBody).sendKeys("Birsen Selvi Coskun");

        wait.until(ExpectedConditions.textToBe(lIframeBody,"Birsen Selvi Coskun"));

        driver.quit();



    }
}
