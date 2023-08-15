package gun05;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01TestSouceDemo extends BaseClass{

    By lUsername = By.id("user-name");
    By lPassword = By.id("password");
    By lLoginButton = By.id("login-button");
    By lUrunAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    By lUrunRemove = By.name("remove-sauce-labs-bike-light");
    By lCart = By.id("shopping_cart_container");

    String loginUsername = "standard_user";
    String loginPassword = "secret_sauce";

    @Test
    public void test_login(){

        //1.  https://www.saucedemo.com/  sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        //2.  login ol
        //find : username -> clear et, send : "standard_user"
        //find : password -> clear et, send : "secret_sauce"
        WebElement eUsername = driver.findElement(lUsername);
        eUsername.clear();
        eUsername.sendKeys(loginUsername);

        WebElement ePassword = driver.findElement(lPassword);
        ePassword.clear();
        ePassword.sendKeys(loginPassword);

        driver.findElement(lLoginButton).click();

        //3.  "Sauce Labs Bike Light" ürününü sepete ekle
        //ürün div'i icindeki ilgili Add to Cart butonuna tikla (id ve ya name)
        //4.  ürünün eklendigini assert et
        //tiklanan Add to Cart butonunun text'i Remove oldu mu
        //5.  sepete git
        //6.  sepette "Sauce Labs Bike Light" ürününün oldugunu assert et
        //remove butonu name veya idsi ile displayed

        sleep(1000);
        driver.quit();

    }


    @Test
    public void test_login2(){

        //1.  https://www.saucedemo.com/  sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        // browser'i maximize eder
        //driver.manage().window().maximize();

        // bowser'in sol üst kösesinin koordinati ayarlandi
        driver.manage().window().setPosition(new Point(100, 10));

        // browser'in genisligi ve yüksekligi set edildi.
        driver.manage().window().setSize(new Dimension(500, 700));

        //2.  login ol
        //find : username -> clear et, send : "standard_user"
        //find : password -> clear et, send : "secret_sauce"
        sendkeys(lUsername, loginUsername);
        sendkeys(lPassword, loginPassword);
        click(lLoginButton);

        //3.  "Sauce Labs Bike Light" ürününü sepete ekle
        //ürün div'i icindeki ilgili Add to Cart butonuna tikla (id ve ya name)
        click(lUrunAddToCart);

        //4.  ürünün eklendigini assert et
        //tiklanan Add to Cart butonunun text'i Remove oldu mu
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());

        //5.  sepete git
        click(lCart);

        //6.  sepette "Sauce Labs Bike Light" ürününün oldugunu assert et
        //remove butonu name veya idsi ile displayed
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());

        sleep(1000);
        driver.quit();

    }







    @Test
    public void test_sendKey(){

        String url = "https://www.saucedemo.com/";
        driver.get(url);

        sendkeys(lUsername, loginUsername);
        sendkeys(lPassword, loginPassword, Keys.ENTER);
        //click(lLoginButton);

        sleep(1000);
        driver.quit();

    }

}
