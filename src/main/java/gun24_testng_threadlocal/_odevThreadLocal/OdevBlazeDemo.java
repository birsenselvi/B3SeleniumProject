package gun24_testng_threadlocal._odevThreadLocal;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class OdevBlazeDemo {

    WebDriver driver;
    WebDriverWait wait;
    public String url = "https://demoblaze.com/";
    By lContactLink = By.linkText("Contact");
    By lMessageDialog = By.xpath("//div[@class='modal-dialog' and .//*[text()='New message']]");
    By lContactEmail = By.id("recipient-email");
    By lContactName = By.id("recipient-name");
    By lMessageText = By.id("message-text");
    By lClose = By.xpath(".//button[text()='Close']");
    By lSendMessage = By.xpath(".//button[text()='Send message']");
    String alertTest = "Thanks for the message!!";


    @BeforeTest
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser){
        driver = Driver.getDriver(browser);
        /*
        switch (browser.toLowerCase().trim()){
            case "edge":
                driver.manage().window().setPosition(new Point(500, 0));
                break;
            case "firefox":
                driver.manage().window().setPosition(new Point(1000, 0));
                break;
            default:
                driver.manage().window().setPosition(new Point(0, 0));
        }
        driver.manage().window().setSize(new Dimension(500, 700));
         */
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void getSite(){
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("STORE"));
    }

    @Test(dependsOnMethods = {"getSite"})
    @Parameters({"contactEmail", "contactName", "messageText"})
    public void message(String contactEmail, String contactName, String messageText){
        click(lContactLink);
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(lMessageDialog));
        senskeys(lContactEmail, contactEmail);
        senskeys(lContactName,contactName);
        senskeys(lMessageText, messageText);
        WebElement send = dialog.findElement(lSendMessage);
        click(send);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), alertTest);
        alert.accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lMessageDialog));
    }


    void click(By locator){
        click(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
    }

    void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    void senskeys(By locator, String text){
        senskeys(wait.until(ExpectedConditions.presenceOfElementLocated(locator)), text);
    }

    void senskeys(WebElement element, String text){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);;
    }

}
