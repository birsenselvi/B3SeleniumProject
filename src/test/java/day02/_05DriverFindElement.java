package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _05DriverFindElement {
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
        // username input unu id ile bulduk ve standard_user degerini atadik.
        By lUsername = By.id("user-name");
        WebElement username = driver.findElement(lUsername);
        System.out.println("username.isEnabled() = " + username.isEnabled());
        username.sendKeys("standard-user");


        //password input unu name ile bulduk ve secret_sauce degerini yazdik
        WebElement password = driver.findElement(By.name("password"));
        System.out.println("password.isDis = " + password.isDisplayed());
        password.sendKeys("secret_souce");

        WebElement loginButton =  driver.findElement(By.id("login-button"));
        System.out.println("loginButton.getAttribut(\"class\") = " + loginButton.getAttribute("class"));
        System.out.println("loginButton.getCssValue = " + loginButton.getCssValue("background-color"));
        loginButton.click();

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
