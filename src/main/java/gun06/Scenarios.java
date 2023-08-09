package gun06;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Scenarios {

    WebDriver driver;


    //instance initializer, constructordan hemen önce calisir
    {
        driver = getDriver();
        driver.manage().window().maximize();
    }



    @Test
    public void scenario1(){
        /*
            https://demoqa.com/
            Elements linkine tiklayin
            Web Tables'a tiklayin
            Last Name'i Vega olan kaydi silin.
            Kaydin silindigini assert edin
         */

        driver.get("https://demoqa.com/");
        By lElements = By.xpath("//div[@class='category-cards']/div[.//*[text()='Elements']]");
        //By lElements = By.xpath("//div[@class='card mt-4 top-card' and .//h5[text()='Elements']]");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
        driver.findElement(lElements).click();
        /*
            tiklama islemi
            1.  selenium click();
            2.  selenium Actions() ile click();
            3.  javascript ile click();
         */


        // div.category-cards>div:first-child
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }



    public WebDriver getDriver(){
        return getDriver("chrome");
    }

    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

}
