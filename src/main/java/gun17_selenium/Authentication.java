package gun17_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class Authentication extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    @Test
    public void test_basicAuthentication1(){
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);

        By basicAuth = By.linkText("Basic Auth");

        driver.findElement(basicAuth).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));
        // acilan sayfada alert gibi görünen ve username password girilmesi gereken
        // bir uyari cikar. Buraya selenium ile ulasilamaz
        // Basic, Digest, Federal Authentication
        // acilan popup alert degildir. Asagidaki satir hata verir
        // driver.switchTo().alert().sendKeys("asasasas");

        /*
            https://siteName.com
            username : user
            password: pass

            Basic authentication
            https://username:password@sitename.com

         */

    }

    @Test
    public void test_basicAuthentication2() {
        String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        driver.get(url);
    }

    @Test
    public void test_basicAuthentication3() {
        String url = "https://the-internet.herokuapp.com/";
        String username = "admin";
        String password = "admin";

        driver.get(url);

        By basicAuth = By.linkText("Basic Auth");

        driver.findElement(basicAuth).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));

        // asagida cuurent url icinde
        //      "https://"     yerine         "https://admin:admin@"        replace ediliyor
        //  current address : https://the-internet.herokuapp.com/basic_auth
        //  replace sonrasi : https://admin:admin@the-internet.herokuapp.com/basic_auth         oluyor
        //  replace edilen adrese de get yapinca basic authentication asiliyor
        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username +":" + password + "@");
        driver.get(url1);
    }

    @Test
    public void test_digestAuthentication4() {
        String url = "https://the-internet.herokuapp.com/";
        String username = "admin";
        String password = "admin";

        driver.get(url);

        By basicAuth = By.linkText("Digest Authentication");

        driver.findElement(basicAuth).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));

        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username +":" + password + "@");
        driver.get(url1);

        // back tusuna basin
        // sayfayi refresh edin
        // forward tusuna basin

    }

    @Test
    public void test_federalAuthentication() {
        // bu sayfada authentication oldugunu düsünün

        String url = "https://the-internet.herokuapp.com/";
        String username = "admin";
        String password = "admin";

        driver.get(url);
        // bu driver.get ile cookie ler olusuturlur. Daha sonra basic_authentication gibi girilir

        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username +":" + password + "@");
        driver.get(url1);

    }
}
