package birsenselviCoskun.aufgabe01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. https://the-internet.herokuapp.com/login  sayfasina gidin
 * 2. Sayfadaki h2 elementinin textinin "Login Page" oldugunu asset edin
 * 3. Formdaki Kullanici ve sifreyi doldurun.
 *    Kullanici: tomsmith
 *    Sifre : SuperSecretPassword!
 * 4. Login butonuna tiklayin
 * 5. Login oldugunuzdan
 *    a) h2 elementinin textinin "Secure Area" oldugunu,
 *    b) h4 elementinin icinde "Welcome to the Secure Area" yazisinin oldugunu
 *    assert ederek emin olun
 */

public class _06 extends BaseClass {
    String url = "https://the-internet.herokuapp.com/login";
    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get(url);

        // Sayfadaki h2 elementinin textinin "Login Page" oldugunu asset edin
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().equalsIgnoreCase("Login Page"));

        // Formdaki Kullanici ve sifreyi doldurun.
        // Kullanici: tomsmith
        // Sifre : SuperSecretPassword!
        By lUsername = By.id("username");
        WebElement username = driver.findElement(lUsername);
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        // Login butonuna tiklayin







        // sleep(3000);
        driver.quit();
    }
}
