package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitlyWait {

    WebDriver driver;

    @Test
    public void test_getRectColorFail(){
        /*  https://www.selenium.dev/selenium/web/dynamic.html
            "Add a box!" butonuna tikla
            cikan karenin rengini consola yazdirin
            rgba(255,0,0,0)
         */
        String url = "https://www.selenium.dev/selenium/web/dynamic.html";
        By lAddBoxButton = By.cssSelector("#adder");
        By lRedBox = By.xpath("//div[@id='box0']");
        driver = new ChromeDriver();

        driver.get(url);

        WebElement button = driver.findElement(lAddBoxButton);
        button.click();
        /*
            click den sonra redBox bir süre gecikmeli geliyor.
            burada Thread.sleep(1000); konursa sorun cözülebilir. KESILIKLE TAVSIYE EDILMEZ.
            Mümkün oldugunca kullanilmamasi lazim.
         */


        WebElement redBox = driver.findElement(lRedBox);
        System.out.println(redBox.getCssValue("background-color"));

        driver.quit();



    }

    @Test
    public void test_explicitlyWait(){
        /*  https://www.selenium.dev/selenium/web/dynamic.html
            "Add a box!" butonuna tikla
            cikan karenin rengini consola yazdirin
            rgba(255,0,0,0)
         */
        String url = "https://www.selenium.dev/selenium/web/dynamic.html";
        By lAddBoxButton = By.cssSelector("#adder");
        By lRedBox = By.xpath("//div[@id='box0']");
        driver = new ChromeDriver();

        // driver'a Implicitly wait eklendi. süre 10 sn
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        /*
            Implicitly Wait
            driver bünyedindedir. Bir sefer tanimlanir. Sürec icinde tekrar tanimlanabilir.
            Bu bekleme element presence oluncaya kadar her element icin beklenir.
            presence : var oluncaya kadar. Kodlarda olan element presence'dir.

         */

        driver.get(url);

        WebElement button = driver.findElement(lAddBoxButton);
        button.click();

        WebElement redBox = driver.findElement(lRedBox);
        System.out.println(redBox.getCssValue("background-color"));
        System.out.println(redBox.isDisplayed());

        driver.quit();

    }

}
