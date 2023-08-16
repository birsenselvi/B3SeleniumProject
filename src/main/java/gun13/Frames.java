package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class Frames extends BaseTest {

    /*
        eger locator'im iframe icinde ise
        driver.switchTo().frame(..);
        ile o iframe icine girilmesi gerekir. Sonra ana pencerede islem yapilacaksa
        tekrar ana pencereye dönülmeli.

        // iframe id'si ya da name'i ile switch edilebilir
        driver.switchTo().frame("my-iframe");

        // iframe element olarak tanimlanir ve switch edilebilir
        WebElement iframe = driver.findElement(lIframe);
        driver.switchTo().frame(iframe);

        // iframe index ile switch edilebilir
        driver.switchTo().frame(0);


     */

    @Test
    public void test_frame1(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/iframes.html";

        By lIframe = By.id("my-iframe");

        By locator = By.xpath("//*[contains(text(),'Lorem ipsum')]");

        driver = Driver.getDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);

        // aranan element iframe icinde oldugu icin iframe'e switch ediyoruz
        // iframe element olarak tanimlanir ve switch edilebilir
        WebElement iframe = driver.findElement(lIframe);
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        // bekleme yok
        // Assert.assertTrue(driver.findElement(locator).isDisplayed());


        driver.quit();

    }

    @Test
    public void test_frame2(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/iframes.html";

        By locator = By.xpath("//*[contains(text(),'Lorem ipsum')]");

        driver = Driver.getDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);

        driver.switchTo().frame(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.switchTo().parentFrame();

        String h5 = driver.findElement(By.cssSelector("h5")).getText();
        System.out.println(h5);
        driver.quit();

    }

    @Test
    public void test_frame3(){
        String url = "https://demoqa.com/nestedframes";

        String iframe1 = "frame1";

        driver = Driver.getDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);

        System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());

        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        sleep(1000);
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector("body")).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector(".main-header")).getText());

        driver.quit();

    }


    @Test
    public void test_frame4(){
        String url = "https://the-internet.herokuapp.com/iframe";

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By lBoldButton = By.cssSelector("button[aria-label='Bold']");
        By lIframe = By.cssSelector("div.tox-edit-area > iframe");
        //By lIframe = By.cssSelector("iframe");
        By lIframeBody = By.id("tinymce");


        driver.get(url);

        //wait.until(ExpectedConditions.elementToBeClickable(lBoldButton)).click();
        click(lBoldButton);

        //driver.switchTo().frame(driver.findElement(lIframe));
        driver.switchTo().frame(0);

        driver.findElement(lIframeBody).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(lIframeBody).sendKeys(Keys.DELETE);
        driver.findElement(lIframeBody).sendKeys("Guidersoft");
        driver.findElement(lIframeBody).sendKeys(Keys.ENTER);
        driver.findElement(lIframeBody).sendKeys("Guidersoft");


        //driver.quit();
    }
}
