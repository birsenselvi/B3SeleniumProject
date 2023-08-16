package gun13;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
}
