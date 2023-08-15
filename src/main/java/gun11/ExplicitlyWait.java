package gun11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExplicitlyWait {

    WebDriver driver;


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
            invisible olmasini, element sayisini,..., beklemesi icin kullanilir.

            --- tanimlanmasi : bir nesne olarak tanimlanir.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(300));

            tanimlamada, driver (zorunlu), bekleme süresi (zorunlu) ve sleep (optional) süresi tanimlanir.
            uygulama icinde istenilen kadar wait tanimlanabilir.

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



    private void baziExplicitWaitExpectedCondirionlari(){

        // tanimlanmis bir locator
        By locator = By.xpath("//a[@id]");

        // tanimlandis bir element
        WebElement element = driver.findElement(locator);

        // Explicitlywait tanimlandi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // bazi Expected conditions
        WebElement element1 = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
}
