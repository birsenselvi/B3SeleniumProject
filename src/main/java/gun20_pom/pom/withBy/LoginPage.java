package gun20_pom.pom.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    private String url = "https://www.saucedemo.com/";
    private By lUsername = By.id("user-name");
    private By lPassword = By.id("password");
    private By lLoginButton = By.id("login-button");
    private By lAppLogo = By.cssSelector(".app_logo");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void gotoSite(){
        driver.get(url);
    }

    public void assertTitle(String title){
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void login(String username, String password){
        sendkeys(lUsername, username);
        sendkeys(lPassword, password);
        click(lLoginButton);
    }

    public ProductPage assertLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lAppLogo));
        return new ProductPage(driver);
    }

}
