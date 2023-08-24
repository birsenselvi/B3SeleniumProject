package gun19.methods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {
    WebDriver driver;
    WebDriverWait wait;

    public Methods() {
        this("chrome");
    }

    public Methods(String browser) {
        setDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public void setDriver() {
        setDriver("chrome");
    }

    public void setDriver(String browser) {
        if (browser.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else
            driver = new ChromeDriver();
    }


}
