package gun04;

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

        /* By locator class'idir. Selenium locatorlari
            By.id();
            By.name();
            By.linkText();
            By.partialLinkText();
            By.className();
            By.cssSelector();
            By.xpath();
         */

        // username input'unu id ile bulduk ve "standard_user" degerini yazdik.
        By lUsername = By.id("user-name");
        WebElement username = driver.findElement(lUsername);
        System.out.println("username.isEnabled() = " + username.isEnabled());
        username.sendKeys("standard_user");

        // password iput'unu name ile bulduk ve "secret_sauce" degerini yazdik.
        WebElement password = driver.findElement(By.name("password"));
        System.out.println("password.isDisplayed() = " + password.isDisplayed());
        password.sendKeys("secret_sauce");

        // login button'unun bulduk ve click ettik.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        System.out.println("loginButton.getAttribute(\"class\") = " + loginButton.getAttribute("class"));
        System.out.println("loginButton.getCssValue(\"background-color\") = " + loginButton.getCssValue("background-color"));
        loginButton.click();


        sleep();
        driver.quit();
    }



    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    
    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

    public static void sleep(){
        sleep(1000);
    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
