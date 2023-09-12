package day31_testNg_cucumber.gmail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailTest {

    String url = "https://mail.google.com";

    WebDriver driver;
    WebDriverWait wait;

    By lemail = By.cssSelector("input[type= 'email']");
    By lButton = By.xpath("//button[contains(., 'Weiter')]");
    String email = "asdfsdf@gmail.com";

    @Before
    public void beforeClass(){

        configure();

    }
    @Test
    public void testGmail(){

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lemail)).sendKeys(email);
        driver.findElement(lButton).click();
    }

    public void configure(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
      //  options.addArguments("--headless"); Chrome acilmadan test eder

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
}
