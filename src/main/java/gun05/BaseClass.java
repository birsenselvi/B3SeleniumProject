package gun05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass(){
        driver = getDriver();
    }

    public WebDriver getDriver(){
        return getDriver("chrome");
    }

    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
        }
    }

    public void sleep(){
        sleep(1000);
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendkeys(By locator, CharSequence...text){
        WebElement eUsername = driver.findElement(locator);
        eUsername.clear();
        eUsername.sendKeys(text);
    }
}
