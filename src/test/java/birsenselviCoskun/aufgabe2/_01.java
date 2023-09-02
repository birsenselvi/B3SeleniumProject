package birsenselviCoskun.aufgabe2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class _01 {
    WebDriver driver;
    //    _01(){
    //        driver = getDriver();
    //    } oder initializer edilir

{
    driver = getDriver();
}

    // Elements linkini bulmak.
    // 1. //div[@class='category-cards']/div[1]
    // 2. //div[@class='category-cards']/div[.//*[text()='Elements']]
    // css ile:
    // 1. div.category-cards > div:first-child
    // //div[4](xpath) --> div:nth-of-type(4)(css)

    By lElements = By.xpath(
            "//div[@class='category-cards']/div[.//*[text()='Elements']]");


    @Test
    public void senario(){
        driver.get("https://demoqa.com/");

    }
    public WebDriver getDriver(){
        return new ChromeDriver();
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
