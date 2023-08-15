package gun10;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTestWithOutWait;
import utils.Driver;

public class TestJavascriptExecuter extends BaseTestWithOutWait {

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

    @Test
    public void test_ScrollIntoView3(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(url);

        By lElement = By.xpath("//p[contains(text(), 'Rutrum conubia')]");
        WebElement element = driver.findElement(lElement);

        // element sayfanin ortasina gelecek sekilde kaydirma islemi yapin
        scrollIntoView(element, false);

        sleep(1000);

        int y = driver.manage().window().getSize().getHeight()/2;
        System.out.println(y);
        scrollBy(y);

        sleep(10000);
        driver.quit();

    }


    @Test
    public void test_ScrollIntoView4(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(url);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");

        sleep();

        By lElement = By.xpath("//p[contains(text(), 'Rutrum conubia')]");
        WebElement element = driver.findElement(lElement);

        // element sayfanin ortasina gelecek sekilde kaydirma islemi yapin
        scrollIntoView(element, false);

        sleep(1000);

        int y = driver.manage().window().getSize().getHeight()/2;
        System.out.println(y);
        scrollBy(y);

        sleep(5000);
        // JavascriptExecuter ile sayfa boyutu degistirilir ise
        // sayfa refresh edildiginde ya da baska bir sayfaya gecildiginde
        // orijinal boyutlarina döner.
        js.executeScript("document.body.style.zoom='200%'");
        sleep();
        js.executeScript("document.body.innerHTML='Selam'");
        sleep(5000);
        driver.quit();

    }



    @Test
    public void buttonClickWithJS(){
        String url = "http://uitestingplayground.com/textinput";
        By input = By.cssSelector("#newButtonName");
        By button = By.cssSelector("#updatingButton");
        driver = Driver.getDriver();

        driver.get(url);

        String text = RandomStringUtils.randomAlphabetic(5, 10);
        sendkeys(input, text);
        sleep(500);
        clickByJs(button);
        sleep(500);
        Assert.assertEquals(driver.findElement(button).getText(), text);
        sleep();


        driver.quit();

    }
}
