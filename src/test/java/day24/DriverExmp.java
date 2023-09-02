package day24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverExmp {
    private static WebDriver driver = null;

    public static WebDriver getDriver(){
        return getDriver("Chrome");
    }
    public static WebDriver getDriver(String browser){

        if(driver == null){
            switch (browser.toLowerCase()){
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case"firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }
    public static void quit(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
