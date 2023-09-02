package day24;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;


import java.time.Duration;

public class AboutUs extends BaseTest {
    String url = "https://www.demoblaze.com/";
    @FindBy(xpath = "//a[@data-target= '#videoModal']")
    WebElement aboutUs;

    @BeforeTest
    public void setup(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    @Test
    public void test(){
        driver.get(url);
        click(aboutUs);

    }
    @AfterTest
    public void rearDown(){
        driver.quit();
    }
}
