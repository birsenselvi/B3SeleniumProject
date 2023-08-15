package gun04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _03DriverMethods {

    static WebDriver driver;

    public static void main(String[] args) {
        driver = getDriver();
        driver.get("https://guidersoft.com/");

        // driver.getTitle() : aktif sayfanin title'ini return eder
        String title = driver.getTitle();
        System.out.println(title);

        // sayfanin title'inin "Home - Guider Soft" oldugunu assert edin
        if (!title.equalsIgnoreCase("Home - Guider Soft"))
            throw new AssertionError("Baslik 'Home - Guider Soft' degil");

        // driver.getPageSource(); -> sayfa kaynak kodlarini verir (html)
        System.out.println(driver.getPageSource());

        // driver.getCurrentUrl(); o anki url'i verir
        System.out.println(driver.getCurrentUrl());

        // driver.getWindowHandle();  aktif pencerenin id'sini verir
        System.out.println(driver.getWindowHandle());

        // driver.getWindowHandles();  aktif pencerelerin id'lerini set olarak verir
        System.out.println(driver.getWindowHandles());

        sleep();

        // aktif olan window'u kapatir.
        driver.close();

        // driver'i ramden siler, acik olan tüm window'lar kapanir
        driver.quit();
    }



    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    
    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

    public static void sleep(){
        sleep(1000);
    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
