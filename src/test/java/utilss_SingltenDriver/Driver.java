package utilss_SingltenDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver =null;
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    public static WebDriver getDriver(String browser){
        if(driver == null) {
            switch (browser.toLowerCase()) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        }
            return driver;

    }
    public static void quid(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
