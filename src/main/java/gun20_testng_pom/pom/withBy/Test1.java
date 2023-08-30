package gun20_testng_pom.pom.withBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Test1 {

    WebDriver driver;
    LoginPage lp;
    ProductPage pp;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        lp = new LoginPage(driver);
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user", "secret_sauce");
        pp = lp.assertLogin();
    }

    @Test(dependsOnMethods = {"test1"})
    public void testProduct(){
        //pp = new ProductPage(driver);
        List<String> names = pp.getListOfProductNames();
        System.out.println(names);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
