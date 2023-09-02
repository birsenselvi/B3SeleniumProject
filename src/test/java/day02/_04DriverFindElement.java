package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _04DriverFindElement {
    static WebDriver driver;
    static String url = "https://www.saucedemo.com/";
    public static void main(String[] args) {

       driver = getDriver();

        driver.get(url);
        // By locator class idir. bu  classlarla id sine göre elementleri buluruz
      /*  By.id();
        By.name();
        By.linkText();
        By.partialLinkText();
        By.className();
        By.cssSelector();
        By.xpath();

       */
        // Enabled : aktif, disabled : pasif

        //user name i input unu id ile bulup "standard user degerini yazdirdik.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //password input unu name ile bulduk ve secret souce degerini yazdik
        driver.findElement(By.name("password")).sendKeys("secret_souce");
        // login button ini bulduk ve click ettik
        driver.findElement(By.id("login-button")).click();

        sleep();
        driver.quit();
    }
    public static WebDriver getDriver(String browser){
        switch(browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();

        }
    }
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    public static void sleep(){
        sleep(1000);
    }
    public static void sleep(long milis){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
