package day32.Opencart.steddefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;


public class OpenCartSteps {

    WebDriver driver;
    WebDriverWait wait;

    By lSearchBox = By.cssSelector("#search input");
    By lsearchProducts = By.cssSelector(".product-thumb");
    By lSearchHeader = By.xpath("//h2[text() = 'Search']");

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {

        driver.get(url);
    }

    @When("user search for {string}")
    public void userSearchFor(String productName) {

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox));
        searchBox.clear();
        searchBox.sendKeys(productName, Keys.ENTER);

    }

    @Then("listed product number soud be {int}")
    public void listedProductNumberSoudBe(int count) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchHeader));
        wait.until(ExpectedConditions.titleContains("Search"));

        int listedProductCount = driver.findElements(lsearchProducts).size();
        Assert.assertEquals(listedProductCount,count);

    }
}
