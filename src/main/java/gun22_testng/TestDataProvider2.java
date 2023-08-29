package gun22_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Utils;

import java.time.Duration;

public class TestDataProvider2 extends BaseTest {

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lUsername = By.cssSelector("form input[name=\"username\"]");
    By lPassword = By.cssSelector("form input[name=\"password\"]");
    By lLoginButton = By.cssSelector("form button");
    By lInvalidCredentialLabel = By.xpath("//p[text()='Invalid credentials']");
    By lUserDropDown = By.cssSelector(".oxd-userdropdown");


    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        Utils.sleep(3000);
        driver.quit();
    }


    @Test
    public void start(){
        driver.get(url);
    }

    @Test(dataProvider = "logindata")
    public void login(String username, String password, boolean login){
        //sendkeys();
    }

    @DataProvider(name = "logindata")
    Object[][] getData(){
        return new Object[][]{
                {"admin1", "1234", false},
                {"admin", "admin123", true},
                {"admin", "admin124", false}

        };
    }
}
