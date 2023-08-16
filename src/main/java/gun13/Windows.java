package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.Set;

public class Windows extends BaseTest {

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
    }

    /*
        bir window'a switch etmek icin o window'un name'i ya da handle'i gereklidir
     */

    String url = "https://www.selenium.dev/selenium/web/rc/tests/html/test_select_window.html";
    By buttonWin1 = By.id("popupPage");
    By buttonWin2 = By.id("popupAnonymous");
    By buttonWin3 = By.id("popupBlank");
    By closeButtonInWin = By.id("closePage2");


    @Test
    public void test_getWindowHandle(){

        String url = "https://google.com";
        driver.get(url);

        // driver.getWindowHandle(); active window'un handle'ini verir
        System.out.println(driver.getWindowHandle());

        driver.quit();
    }


    @Test
    public void test_getWindowHandles(){

        driver.get(url);

        click(buttonWin1);

        // driver.getWindowHandles(); acik olan tüm windowlarin handle'larini Set<String> olarak verir
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);

        driver.quit();

    }


    @Test
    public void test_switchToWin(){

        driver.get(url);

        String mainWin = driver.getWindowHandle();
        String childWin = "";
        click(buttonWin1);

        Set<String> windowHandles = driver.getWindowHandles();

//        for (String windowHandle : windowHandles) {
//            if (!windowHandle.equals(mainWin)){
//                childWin = windowHandle;
//                break;
//            }
//        }

        childWin = windowHandles
                .stream()
                .filter(w -> !w.equals(mainWin))
                .findFirst()
                .get();

        driver.switchTo().window(childWin);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closePage2")));

        driver.quit();
    }

    @Test
    public void test_switchToWin2(){

        driver.get(url);

        // buttonWin3 tiklayin
        click(buttonWin3);

        // win sayisinin 2 olmasini bekleyin
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // active windowun handlw ini alin
        String mainWin = driver.getWindowHandle();

        // yeni win'e switch edin ve butona tiklayip kapatin
        driver.switchTo().window(getNewWinHandle(mainWin));
        click(closeButtonInWin);

        // kapandigini assert edin
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));

        //Assert.assertEquals(driver.getWindowHandles().size(), 1);

        // main wine switch edin
        driver.switchTo().window(mainWin);

        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonWin1));

        driver.quit();
    }


    public String getNewWinHandle(String activeWinHandle){
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(activeWinHandle))
                return windowHandle;
        }
        return null;
    }


    @Test
    public void test_switchToWin3(){

        String url1 = "https://google.com";
        String url2 = "https://yahoo.com";
        String url3 = "https://demoqa.com/";

        // google'i main win de ac
        driver.get(url1);

        String googleHandle = driver.getWindowHandle();;

        // yahoo'u da new TAB'da acar ve o sayfaya switch eder
        driver.switchTo().newWindow(WindowType.TAB).get(url2);

        sleep(1000);

        // active windowu kapatir
        driver.close();

        // ana sayfada islem yapabilmek icin tekrar ana sayfaya switch etmek gerekir
        driver.switchTo().window(googleHandle);

        // adresi yeni window da acar
        driver.switchTo().newWindow(WindowType.WINDOW).get(url3);
        sleep(1000);
        driver.close();

        driver.switchTo().window(googleHandle);
        driver.findElement(By.id("L2AGLb")).click();

        sleep(1000);
        driver.quit();

    }

}
