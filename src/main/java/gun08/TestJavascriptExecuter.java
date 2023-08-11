package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

public class TestJavascriptExecuter extends BaseTest {

    /*
        Sayfada kaydirma islemler (scroll) JavaScriptExecuter ile yapilir

        ScrollBy(x, y)  : bulundugu yerden x kadar saga/sola, y kadar asagi/yukari kaydir
        ScrollTo(x,y)   : x, y noktasina git. Statik bir noktaya gider
        ScrollIntoView(): belirtilen elemente kadar scrol eder.
     */

    String url = "https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html";

    @Test
    public void text_scrollBy(){

        driver = Driver.getDriver();

        driver.get(url);

        // bulundugu yerden x ve y kadar hareket eder
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        sleep(2000);

        driver.quit();

    }

    @Test
    public void text_scrollBy2(){

        driver = Driver.getDriver();

        driver.get(url);

        for (int i = 0; i < 10; i++) {
            scrollBy(200);
            sleep(200);
        }

        for (int i = 0; i < 5; i++) {
            scrollBy(-200);
            sleep(200);
        }

        driver.quit();

    }

    @Test
    public void text_scrollTo(){

        driver = Driver.getDriver();

        driver.get(url);

        // verilen x, y noktasina gider
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(100, 500);");

        sleep(2000);

        driver.quit();

    }


    @Test
    public void text_scrollTo2(){

        driver = Driver.getDriver();

        driver.get(url);

        for (int i = 0; i < 5; i++) {
            scrollBy(200);
            sleep(300);
        }

        scrollTo(0);

        sleep(4000);
        driver.quit();

    }


    @Test
    public void test_ScrollIntoView(){
        driver = Driver.getDriver();

        driver.get(url);

        By lElement = By.xpath("//p[contains(text(), 'Rutrum conubia')]");
        WebElement element = driver.findElement(lElement);

        // belirtilen elemente gider
        // scrollIntoView(); veya scrollIntoView(true); ise
        //      elementin üst kismini sayfanin üstüne hizalar
        // scrollIntoView(false); ise
        //      elementin alt kismini sayfanin altina hizalar
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        // element.scrollIntoView();

        sleep(10000);
        driver.quit();

    }

    @Test
    public void test_ScrollIntoView2(){
        driver = Driver.getDriver();

        driver.get(url);

        By lElement = By.xpath("//p[contains(text(), 'Rutrum conubia')]");
        WebElement element = driver.findElement(lElement);

        scrollIntoView(element, false);

        sleep(10000);
        driver.quit();

    }

}
