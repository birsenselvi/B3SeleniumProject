package gun23_testng_xml.xml2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseClass {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("chrome") String browser){
        if (browser.trim().equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else if (browser.trim().equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else
            driver = new ChromeDriver();

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterTest
    public void afterTest(){
        driver.quit();
    }


}
