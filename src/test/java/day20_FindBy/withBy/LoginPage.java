package day20_FindBy.withBy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BAsePAge{

    String url = "";
    By lUsername = By.id("");
    By lPassword = By.id("");
    By lLoginButton = By.id("" );
    private By lAppLogo = By.id("");


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

        sendKeys(lUsername, username);
        sendKeys(lPassword, password);
        click(lLoginButton);
        assertLogin(lAppLogo);
    }

}
