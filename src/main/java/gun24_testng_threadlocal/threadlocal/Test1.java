package gun24_testng_threadlocal.threadlocal;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;
import utils.DriverStatic;

public class Test1 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        driver = Driver.getDriver();
        //driver = Driver.drivers.get();
        //driver = DriverStatic.driver;
    }

    @Test
    public void test1(){
        driver.get("https://google.com");
    }

    @AfterTest
    public void afterTest(){
        Driver.quit();
    }
}
