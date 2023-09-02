package day13_WindowsGecisleri_SwitchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {
    WebDriver driver;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/iframes.html";
    WebDriverWait wait;
    By locator = By.xpath("//*[contains(text(),'Lorem ipsum')]");
    By liframe = By.id("my-iframe");

    /**
     * eger locator ifarem icinde ise driver.switchTo().frame(..);
     * ile icerisine girilmelidir. sonra ana pencerede islem yapilacaksa
     * tekrar ana pencereye dönülmeli
     */
    @Test
    public void test_frame(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get(url);
        // aranan element iframe icinde oldugu icin iframe switch ediyoruz

        // 1.

        // driver.switchTo().frame("my-iframe");

        // 2.

        WebElement iframe = driver.findElement(liframe);
        driver.switchTo().frame(iframe);

        // 3. index ile
        // driver.switchTo().frame(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        // tekrardan iframe den cikmali islem yapabilmesi icin
        driver.switchTo().parentFrame();
        String h5 = driver.findElement(By.xpath("//h5")).getText();
        System.out.println(h5);



        //  Assert.assertTrue(driver.findElement(locator).isDisplayed());

        driver.quit();




    }
}
