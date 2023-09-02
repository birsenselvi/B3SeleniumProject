package day13_WindowsGecisleri_SwitchTo;


import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.Set;

public class Windows extends BaseTest {
    /**
     * bir window a
     */
    {
        driver = utils.Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(200));

    }
    By buttonWin1 = By.id("popupPage");
    By buttonWin2 = By.id("popupAnonymous");
    By buttonWin3 = By.id("popupBlank");
    String url = "https://www.selenium.dev/selenium/web/rc/tests/html/test_select_window.html";
    @Test
    public void test_getWindows(){
        String url = "https://google.com";

        //driver.getWindowHandles() = aktive window un hande ini verir.
        System.out.println(driver.getWindowHandles());
        driver.quit();

    }
    @Test
    public void test_getWindowsss(){

        driver.get(url);

        driver.findElement(buttonWin1).click();

        Set<String> wins = driver.getWindowHandles();
        System.out.println(wins);

        driver.quit();

    }
    @Test
    public void test_switchToWin(){

        driver.get(url);


        String mainWin = driver.getWindowHandle();
        String childWin = "";

        driver.findElement(buttonWin1).click();

        Set<String> wins = driver.getWindowHandles();
        System.out.println(wins);

        /*for (String windowHandle : wins) {
            if (!windowHandle.equals(mainWin)) {
                childWin = windowHandle;
                break;
            }
        }
        driver.switchTo().window(childWin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closePage2")));*/

        childWin = wins
                .stream()
                .filter(w->!w.equals(mainWin))
                .findFirst()
                .get();

        driver.switchTo().window(childWin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("closePage2")));

        driver.quit();

    }
    @Test
    public void test_click(){
        /**
         *         // buttonWin3 tiklayin
         *         // win sayisinin 2 olmasini bekleyin
         *         // active windowun handlw ini alin
         *         // yeni win'e switch edin ve butona tiklayip kapatin
         *         // kapandigini aeert edin
         *         // main wine switch edin
         */

        driver.get(url);

        String childWin = "";


        driver.findElement(buttonWin3).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String mainWin = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());

       Set<String> wins = driver.getWindowHandles();
        System.out.println(wins);
        childWin = wins
                .stream()
                .filter(w->!w.equals(mainWin))
                .findFirst()
                .get();
        driver.switchTo().window(childWin);
        driver.findElement(By.id("closePage2")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
        driver.switchTo().window(mainWin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonWin1));

        driver.quit();

    }
    @Test
    public void test_switchToWin3(){
        String url = "https://google.com";
        String url1 = "https://yahoo.com";
        String url2 = "https://gmail.com";
        driver.get(url);
        String googleHandle = driver.getWindowHandle();
        //ikinci sayfayi tab olarak acmak
        driver.switchTo().newWindow(WindowType.TAB).get(url1);
        sleep(2000);
        // Active olan pencereyi kapatir.
        driver.close();
        //active sayfa kapandiktan sonra ana sayfaya tekrar döndürülür. sonra islem yapilir.
        driver.switchTo().window(googleHandle);

        driver.switchTo().newWindow(WindowType.WINDOW).get(url2);

        sleep(3000);
        driver.quit();
    }
}
