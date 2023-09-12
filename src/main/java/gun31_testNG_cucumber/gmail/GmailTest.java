package gun31_testNG_cucumber.gmail;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailTest {

    String url = "https://mail.google.com";
    WebDriver driver;
    WebDriverWait wait;

    By lEmail = By.cssSelector("input[type='email']");
    By lContinue = By.xpath("//button[contains(., 'Weiter')]");
    String eMail = "atezgider@gmail.com";

    @Before
    public void beforeClass(){
        configure();
    }

    @Test
    public void testGMail(){
        driver.get(url);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(lEmail)).sendKeys(eMail);
        //driver.findElement(lContinue).click();

    }

    public void configure(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("user-data-dir=C:\\Users\\pc\\AppData\\Local\\Google\\Chrome\\User Data");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}
