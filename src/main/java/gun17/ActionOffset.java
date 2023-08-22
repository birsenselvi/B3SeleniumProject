package gun17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ActionOffset extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://www.snapdeal.com/product/hmct-615-metal-analog-mens/652415109752#bcrumbSearch:watch";

    By cssSelector = By.cssSelector("#bx-slider-left-image-panel img:nth-of-type(1)");
    By xpath = By.xpath("(//*[@id='bx-slider-left-image-panel']//img)[1]");
    By acceptCookies = By.cssSelector("#adroll_allow_all");


    @Test
    public void testOffset(){
        driver.get(url);

        // ihtiyac duyulursa farkli bekleme süresi ve sleep ile wait tanimlanabilir.
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(10));

        // Cookie accept button'in visible olmasini bekleyip click ediyoruz.
        wait1.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies)).click();

        // click sonrasi cookie accept button'in invisible olmasini bekliyoruz
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookies));


        // ActionClass'inda
        // moveToElement(element) -> o elementin orta noktasina gider, x=0, y=0
        // moveToElement(element, xOffset, yOffset) -> o elementin x, y koordinatlarina gider
        WebElement saat = driver.findElement(xpath);
        new Actions(driver).moveToElement(saat).perform();

        sleep(2000);
        move(saat, -100, -100);

        sleep(2000);
        move(saat, 100, 100);

        sleep(2000);
        move(saat, 100, -100);

        sleep(2000);
        move(saat, -100, 100);

        sleep(2000);
        move(saat, 1000, 1000);



    }



    @Test
    public void testOffset2(){

        driver.get(url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookies)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(acceptCookies));

        WebElement saat = driver.findElement(xpath);

        int width = saat.getSize().getWidth();
        int height = saat.getSize().getHeight();

        int x = width/2;
        int y = height/2;

        for (int i = 0; i < height; i++) {
            move(saat, 0, -y+i);
        }



    }


    public void move(WebElement element, int x, int y){
        new Actions(driver).moveToElement(element, x, y).perform();
    }
}
