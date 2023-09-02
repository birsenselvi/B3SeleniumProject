package day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class _03DriverMethods {
    static WebDriver driver;
    public static void main(String[] args) {

       driver = getDriver("chrome");

        driver.get("https://guidersoft.com");

        // driver.getTitle(): aktif sayfanin ismini return eder.
       // System.out.println(driver.getTitle());
        String title = driver.getTitle();
        System.out.println(title);

        //sayfanin title nin "Home- guidersoft oldugunu assert(dogrulamak) edin.
        if(!title.equalsIgnoreCase("Home- Guider Soft"))
            throw new AssertionError("Baslik ayni degil");

        //driver.getPageSource() :  sayfa kaynak kodlarini yazdirir(html)
        System.out.println(driver.getPageSource());

        // driver.getCurrentUrl() : o anki url´i verir.
        System.out.println(driver.getCurrentUrl());

        // driver.getWindowHandle() : aktif pencerenin Id sini verir.
        System.out.println(driver.getWindowHandle());

        // driver.getWindowHandles() : aktif pencerelerin id lerini set olarak verir.
        System.out.println(driver.getWindowHandles());

        // aktif olan pencereyi(window) kapatir.
        driver.close();
        sleep();
        // driver i ramdan siler, acik olan tüm windowslar kapanir.
        driver.quit();
    }
    public static WebDriver getDriver(String browser){
        switch(browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();

        }
    }
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }
    public static void sleep(){
        sleep(1000);
    }
    public static void sleep(long milis){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
