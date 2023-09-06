package day27_senerio_yapilacak;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class BaseTest{
    WebDriver driver;

    WebDriverWait wait;

    @BeforeTest
    public void start(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @AfterTest
    public void tearDown(){
        // driver.quit();
    }
    public void click(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeys(WebElement element , String text){

        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }

    public void assertVisiblity(WebElement element){

        assertVisiblity(element,true);

    }

    public void assertVisiblity(WebElement element, boolean visible){

        if(visible){
            wait.until(ExpectedConditions.visibilityOf(element));
        }else{
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
    }


}