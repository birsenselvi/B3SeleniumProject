package birsenselviCoskun.aufgabe01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

   WebDriver driver;

   BaseClass(){
       driver= getDriver();
   }
   public WebDriver getDriver(){
       return getDriver("chrome");
   }
   public WebDriver getDriver(String browser){
       switch (browser.toLowerCase().trim()){
           case"edge":
               return new EdgeDriver();
           case "firefox":
               return new FirefoxDriver();
           default:
               return new ChromeDriver();
       }
   }
   public void sleep(){
       sleep(2000);
   }
   public void sleep(long milis){
       try{
           Thread.sleep(2000);
       }catch (InterruptedException e){
           throw new RuntimeException();
       }
   }
   public void click(By locator){
       driver.findElement(locator).click();
   }
   public void sendKeys(By locator, CharSequence...text){
       WebElement eUsername = driver.findElement(locator);
       eUsername.clear();
       eUsername.sendKeys(text);
   }

}
