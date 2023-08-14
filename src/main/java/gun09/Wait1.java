package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Wait1 {

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
    public void test_getRectColor(){
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
            driver bünyedindedir. Bir sefer tanimlanir.
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

    @Test
    public void test_ExplicitlyWait1Fail(){
        /*  https://www.selenium.dev/selenium/web/dynamic.html
            "Reveal a new input" butonuna tikla
            Adini yazdir
         */
        String url = "https://www.selenium.dev/selenium/web/dynamic.html";
        By lRevealButton = By.cssSelector("#reveal");
        By lRevealInput = By.cssSelector("#revealed");

        driver = new ChromeDriver();

        driver.get(url);

        driver.findElement(lRevealButton).click();
        driver.findElement(lRevealInput);

        // burada hata olustu. Element kodlarda var.
        // WebDriver elementi buluyor ancak sendkey yapamiyor
        driver.findElement(lRevealInput).sendKeys("GuiderSoft");

        driver.quit();

    }

    @Test
    public void test_ExplicitlyWait2(){
        /*
            ExplicitWait : Elemente özel islemleri gerceklestirir.
            visible olmasini, precense olmasini, renginin deismesini,
            invisible olmasini, element sayisini,

         */
        String url = "https://www.selenium.dev/selenium/web/dynamic.html";
        By lRevealButton = By.cssSelector("#reveal");
        By lRevealInput = By.cssSelector("#revealed");

        driver = new ChromeDriver();

        // wait : Explicitly wait olarak taimlandi. Bekleme süresi 10 sn.
        // Her 500 ms = 0.5sn bir elementin istenen sarta uygun olup olmadigini ontrol eder.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // wait1 : Explicitly wait olarak taimlandi. Bekleme süresi 20 sn.
        // Her 300 ms bir elementin istenen sarta uygun olup olmadigini ontrol eder.
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(300));

        driver.get(url);

        driver.findElement(lRevealButton).click();

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lRevealInput));
        input.sendKeys("GuiderSoft");



        driver.quit();

    }



    @Test
    public void test_ExplicitlyWait3(){
        String url = "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";


        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);

        By imgs = By.cssSelector("#image-container img");

        List<WebElement> images = wait.until(ExpectedConditions.numberOfElementsToBe(imgs, 4));

        for (WebElement element : images) {
            System.out.println(element.getAttribute("alt") + " : " + element.getLocation().x + ", " + element.getLocation().y);
        }

        driver.quit();



    }


    @Test
    public void test_ExplicitWait4(){
        /*
            https://the-internet.herokuapp.com/dynamic_controls

            1.  Remove butonuna tikla
                checkbox'in invisible oldugunu assert et.
            2.  "Add" butonuna tikla
                checkbox'in visible oldugunu assert et.

            3.  Enable butonuna tikla
                inputbox'in enable olmasini bekle

            4.  Disable butonuna tikla
                inputbox'in disable olmasini bekle


         */
    }
}
