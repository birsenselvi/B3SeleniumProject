package birsenselviCoskun.aufgabe01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01 {
    static WebDriver driver;
    static String url = "https://www.saucedemo.com/";

    @Test
    public void test(){
        driver = getDriver();
        driver.get(url);

        By username1 = By.id("user-name");
        WebElement username = driver.findElement(username1);
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addToCart = driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        addToCart.click();

        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());

        WebElement shopping = driver.findElement(By.id("shopping_cart_container"));
        shopping.click();

        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/cart.html"));
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());

        sleep();
        driver.quit();

    }
    public static WebDriver getDriver(String browser){
        if (browser.toLowerCase().trim().equalsIgnoreCase("edge")) {
            return new EdgeDriver();
        } else if (browser.toLowerCase().trim().equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }else{
            return new ChromeDriver();
        }
    }
    public static WebDriver getDriver(){
        return new ChromeDriver();
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
