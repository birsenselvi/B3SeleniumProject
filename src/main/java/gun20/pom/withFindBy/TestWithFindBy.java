package gun20.pom.withFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestWithFindBy {

    WebDriver driver;
    LoginPage lp;


    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

        //LoginPage lp1 = PageFactory.initElements(driver, LoginPage.class);

        lp = new LoginPage(driver);
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user", "secret_sauce");
        lp.assertLogin();
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
