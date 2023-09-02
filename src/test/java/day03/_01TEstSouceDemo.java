package day03;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _01TEstSouceDemo extends gun05_selenium.BaseClass {

    By lUsername = By.id("user-name");
    By lPassword = By.id("password");
    By lLoginButton = By.id("login-button");
    By lUrunAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    By lUrunRemove = By.id("remove-sauce-labs-bike-light");


    String loginUsername = "standard_user";
    String loginPassword = "secret_sauce";
    @Test
    public void test_login(){


        // "https://www.saucedemo.com/"; sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        // browser i maximall eder.
        // driver.manage().window().maximize();
        // driver.manage().window().getSize();
        driver.manage().window().getPosition();
        // browser in sol üst kösesinin koordinati ayarlandi.
        driver.manage().window().setPosition(new Point(100, 10));
        //browser in genisligi ve yüksekligi ayarlandi.
        driver.manage().window().setSize(new Dimension(500, 700));


        // login ol
        sendkeys(lUsername,loginUsername) ;
        sendkeys(lPassword,loginPassword) ;

        click(lLoginButton);

        click(lUrunAddToCart);

        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());


        sleep();
        driver.quit();
    }
    @Test
    public void test_login1(){


        // "https://www.saucedemo.com/"; sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        // login ol
        WebElement eUsername = driver.findElement(lUsername);
        eUsername.clear();
        eUsername.sendKeys(loginUsername);

        WebElement ePassword = driver.findElement(lPassword);
        ePassword.clear();
        ePassword.sendKeys(loginPassword);

        driver.findElement(lLoginButton).click();

        sleep();
        driver.quit();
    }
    @Test
    public void test_sendKeys(){


        // "https://www.saucedemo.com/"; sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        // login ol
        sendkeys(lUsername,loginUsername) ;
        sendkeys(lPassword,loginPassword, Keys.ENTER) ;

        // Keys.Enter click() method yerine kullanilabilir

        // click(lLoginButton);

        sleep();
        driver.quit();
    }
}
