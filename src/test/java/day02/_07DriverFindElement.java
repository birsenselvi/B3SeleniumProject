package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _07DriverFindElement {
    static WebDriver driver;
    static String url = "https://www.saucedemo.com/";
    @Test
    public void test1() {

       driver = getDriver();

        driver.get(url);
        // By locator class idir. buclasslarla id sine göre elementleri buluruz. Selenium locatorlari
      /*  By.id();
        By.name();
        By.linkText();
        By.partialLinkText();
        By.className();
        By.cssSelector();
        By.xpath();

       */
        // Enabled : aktif, disabled : pasif
        By lUsername = By.id("user-name");
        WebElement username = driver.findElement(lUsername);
        System.out.println("username.isEnabled() = " + username.isEnabled());
        username.sendKeys("standard_user");


        WebElement password = driver.findElement(By.name("password"));
        System.out.println("password.isDis = " + password.isDisplayed());
        password.sendKeys("secret_sauce");

        WebElement loginButton =  driver.findElement(By.id("login-button"));
        System.out.println("loginButton.getAttribut(\"class\") = " + loginButton.getAttribute("class"));
        System.out.println("loginButton.getCssValue = " + loginButton.getCssValue("background-color"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());

        driver.findElement(By.linkText("Sauce Labs Backpack")).click();


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
        sleep(3000);
    }
    public static void sleep(long milis){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
