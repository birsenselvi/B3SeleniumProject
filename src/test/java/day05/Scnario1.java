package day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *         https://demoqa.com/
 *         Elements linkine tiklayin
 *         Text Box'a tiklayin
 *         Acilan formu doldurun
 *         Submit butonuna tiklayin
 *         Girdiginiz verilerin fomun alt kisminda ciktigini
 *         dogrulayin
 */

public class Scnario1 {
    WebDriver driver = new ChromeDriver();
    String url = "https://demoqa.com/text-box";
    @Test
    public void test(){

        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.cssSelector("#userName")).sendKeys("Selvi");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("selvi@gmail.com");
        driver.findElement(By.xpath("(//textarea)[1]")).sendKeys("MyCurrentAddress");
        driver.findElement(By.xpath("(//textarea)[2]")).sendKeys("MyParmanentAdress");
        //driver.findElement(By.id("submit")).click();
        driver.findElement(By.cssSelector("button#submit")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("p#name")).getText().contains("Selvi"));

        driver.quit();
    }
}
