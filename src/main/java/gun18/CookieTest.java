package gun18;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.Set;

public class CookieTest extends BaseTest {

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    String url = "https://bonigarcia.dev/selenium-webdriver-java/cookies.html";
    @Test
    public void test_getCookies(){

        driver.get(url);

        // cookie leri siler
        //driver.manage().deleteAllCookies();

        // sayfadaki cookie leri aldik
        Set<Cookie> cookies = driver.manage().getCookies();


        for (Cookie cookie : cookies) {
            System.out.println("cookie.getName() = " + cookie.getName());
            System.out.println("cookie.getValue() = " + cookie.getValue());
        }

        Cookie myCookie = new Cookie("text", RandomStringUtils.randomAlphabetic(10, 20));
        driver.manage().addCookie(myCookie);

        System.out.println("text cookie = " + driver.manage().getCookieNamed("text"));
        driver.quit();
    }
}
