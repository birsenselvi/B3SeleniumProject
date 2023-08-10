package gun07;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver;

public class Test1 {

    WebDriver driver;

    @Test
    public void test1(){
        driver = Driver.getDriver("edge");
        driver.get("https://google.com");

        driver = Driver.getDriver("edge");
        driver.get("https://yahoo.com");

        driver = Driver.getDriver();
        driver.get("https://google.com");

    }
}
