package gun34_hooks_scenarioOutline.scenarioOutline2.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SdPage extends SdBaseTest{

    final String url = "https://www.saucedemo.com/";

    /*
    public SdPage(){
        PageFactory.initElements(driver, this);
    }
     */

    @FindBy(id = "user-name")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login-button")
    public WebElement buttonLogin;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartContainer;

    @FindBy(css = "h3[data-test=\"error\"]")
    public WebElement errorMessage;

    public void gotoPage(){
        driver.get(url);
    }


    public void login(String username, String password){
        sendkeys(inputUsername, username);
        sendkeys(inputPassword, password);
        click(buttonLogin);
    }

    public void loginSuccessful(boolean login){
        if(login){
            waitForVisibility(cartContainer);
        } else {
            waitForVisibility(errorMessage);
        }
    }

}
