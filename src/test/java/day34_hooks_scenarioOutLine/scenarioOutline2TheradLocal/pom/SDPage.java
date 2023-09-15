package day34_hooks_scenarioOutLine.scenarioOutline2TheradLocal.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SDPage extends SdBaseTest{
    final String url = "https://saucedemo.com";
    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement login;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartContainer;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;

    public void gotoHome(){
        driver.get(url);
    }

}
