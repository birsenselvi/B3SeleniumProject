package day19_TEstNg.Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class TEstNgGrs {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){

        driver =new ChromeDriver();

    }

}
