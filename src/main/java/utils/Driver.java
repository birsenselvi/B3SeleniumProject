package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver = null;

    /**
     *
     * @return WebDriver
     */
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    /**
     * Yukarida private olarak define edilmis driver null ise tanimlar ve return eder.
     * driver null degil ise, daha önce tanimli ise driveri tanimlamaz ve önceki driveri return eder
     * @param browser browser name
     * @return WebDriver
     */
    public static WebDriver getDriver(String browser){

        // driver == null kontrolü olmaz ise bu method her cagrildiginda
        // yeni bir driver create edilir
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "edge":
                    // WebDriverManager.edgedriver().setup();
                    // Selenium 4.11.0 öncesi versiyonlarda WebDriverManager
                    // ile istenen driverin setup edilmesi gerekmektedir.
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    // WebDriverManager.firefoxDriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    // WebDriverManager.chromeDriver().setup();
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }

    /**
     * driver.quit methodu. driver=null yapiliyor ki,
     * tekrar cagrildiginda getDriver icindeki if (driver==null) sarti saglanmis olsun
     * driver null degil ise yeni driver tanimlanmayacaktir.
     */
    public static void quit(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
