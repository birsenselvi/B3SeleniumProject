package day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

public class test07{
    /**
     *             https://practice.expandtesting.com/login
     *             username ve password girin
     *             login butonunun background-color'ini consola yazdirin
     *             login butonuna tiklayin
     *
     *             login oldugunuzu "Secure Area" yazisi ya da "logout" linki ile assert edin
     *
     *             logout'a tiklayin
     *
     *             "Login Page" yazisi ya da login butonu ile ciktiginizi assert edin
     */

    WebDriver driver;

    @Test
    public void test(){

        driver = Driver.getDriver();
        driver.get("https://practice.expandtesting.com/login");
        driver.findElement(By.cssSelector("#username")).sendKeys("practice");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type = 'submit']")).click();
        driver.findElement(By.xpath("//h1[text() = 'Secure Area']"));
        System.out.println(driver.findElement(By.cssSelector("button[type = 'submit']")).getCssValue("background-color"));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text() = 'Secure Area']")).isDisplayed());








    }
}
