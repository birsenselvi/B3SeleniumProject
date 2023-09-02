package day20_FindBy.TEstbox;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TEstBoxPAge {
    WebDriver driver;
    WebDriverWait wait;

    String url = "https://demoqa.com/text-box";
    @FindBy(id = "userName")
     WebElement userName;
    @FindBy(id = "userEmail")
     WebElement userEmail;

    @FindBy(id = "currentAddress")
     WebElement currentAddress;

    @FindBy(id = "permanentAddress")
     WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement button;

    @FindBy(id = "output")
    WebElement output;


    public TEstBoxPAge(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void gotoSite(){
        driver.get(url);
    }
    public void assertisDisplayed(WebElement element){

        Assert.assertTrue(element.isDisplayed());
    }

    public void click(WebElement element){

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userName);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

}
