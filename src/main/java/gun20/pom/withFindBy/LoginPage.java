package gun20.pom.withFindBy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement eUsername;

    @FindBy(how = How.ID, using = "password")
    private WebElement ePassword;

    @FindBy(id = "login-button")
    private WebElement eLoginButton;

    @FindBy(css = ".app_logo")
    private WebElement eAppLogo;

    public LoginPage(WebDriver driver) {
        super(driver);

        // bu initialize olmaz ise element olusturulmaz ve NullPointerException
        PageFactory.initElements(driver, this);

        // ajax beklemesi yapmak icin yukaridaki PageFactory.initElements asagidaki gibi revize edilir
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
    }

    public void gotoSite(){
        driver.get(url);
    }

    public void assertTitle(String title){
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void login(String username, String password){
        sendkeys(eUsername, username);
        sendkeys(ePassword, password);
        click(eLoginButton);
    }

    public void assertLogin(){
        wait.until(ExpectedConditions.visibilityOf(eAppLogo));
    }

}
