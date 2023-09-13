package gun32_cucumber.orangeHRM.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.Map;

public class OrangeHRMSteps {

    String url =  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    WebDriverWait wait;
    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lLogin = By.xpath("//button[contains(., 'Login')]");
    By lSidePanel = By.cssSelector(".oxd-sidepanel");


    public OrangeHRMSteps(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("user on homepage")
    public void userOnHomepage() {
        driver.get(url);
    }

    @When("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        Map<String, String> map = table.asMap();

        String username = map.get("username");
        String password = map.getOrDefault("password", "admin123");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys(username);
        driver.findElement(lPassword).sendKeys(password);
        driver.findElement(lLogin).click();
    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSidePanel));
    }
}
