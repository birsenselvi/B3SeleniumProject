package day18_tryCAtch;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.Set;

public class Cookiess extends BaseTest {
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    String url = "https://bonigarcia.dev/selenium-webdriver-java/cookies.html";

    @Test
    public void test1(){
        driver.get(url);
        Set<Cookie> cookies = driver.manage().getCookies();

        for (Cookie cookie: cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

        Cookie myCookie = new Cookie("Text", "selenium");
        driver.manage().addCookie(myCookie);

        System.out.println(driver.manage().getCookieNamed("Text"));

        driver.quit();
    }
}
