package gun20.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class Test1Base {

    /*
        Suite
            Test
                Group   ->
                    Class
                        Method
     */

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

    public void click(By locator){
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        WebElement element = elements
                .stream()
                .filter(e -> e.isDisplayed())
                .findFirst().get();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
