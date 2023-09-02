package day10.Alertsss;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



import java.time.Duration;

public class Alerts {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demoqa.com/alerts";
    Alerts(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void testt(){
        driver.get(url);
        By lAlertBotton = By.id("alertButton");
        driver.findElement(lAlertBotton).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


        driver.quit();

    }
}
