package day14_HoverMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;


import java.time.Duration;
import java.util.List;

public class ActionClass1 extends BaseTest {
    {
        driver= Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void actionsC(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By lDesktops = By.xpath("//a[text() ='Desktops']");
        WebElement desktops = wait.until(ExpectedConditions.visibilityOfElementLocated(lDesktops));

        // hover methodu. Elementin üzerine gidip bekler.

        Actions actions = new Actions(driver); // aksiyon tanimlaniyor.
        actions
                .moveToElement(desktops)
                .pause(100)
                .build()    // yukaridaki siralanan islemleri yapar.
                .perform(); // build edilen islemleri yapar

    }
    @Test
    public void actionsC2(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By lDesktops = By.xpath("//a[text() ='Desktops']");
        WebElement desktops = wait.until(ExpectedConditions.visibilityOfElementLocated(lDesktops));
        By lLaptops = By.xpath("//a[text() ='Laptops & Notebooks']");
        WebElement laptops = wait.until(ExpectedConditions.visibilityOfElementLocated(lLaptops));
        By lComponents = By.xpath("//a[text() ='Components']");
        WebElement Components = wait.until(ExpectedConditions.visibilityOfElementLocated(lComponents));
        By lTablets = By.xpath("//a[text() ='Tablets']");
        WebElement Tablets = wait.until(ExpectedConditions.visibilityOfElementLocated(lTablets));
        By lSoftware = By.xpath("//a[text() ='Software']");
        WebElement Software = wait.until(ExpectedConditions.visibilityOfElementLocated(lSoftware));
        By lPhonePDAs = By.xpath("//a[text() ='Phones & PDAs']");
        WebElement PhonePDAs = wait.until(ExpectedConditions.visibilityOfElementLocated(lPhonePDAs));
        By lCameras = By.xpath("//a[text() ='Cameras']");
        WebElement Cameras = wait.until(ExpectedConditions.visibilityOfElementLocated(lCameras));
        By lMP3Players = By.xpath("//a[text() ='MP3 Players']");
        WebElement MP3Players = wait.until(ExpectedConditions.visibilityOfElementLocated(lMP3Players));

        // hover methodu. Elementin üzerine gidip bekler.

        Actions actions = new Actions(driver); // aksiyon tanimlaniyor.
        actions
                .moveToElement(desktops)
                .moveToElement(laptops)
                .moveToElement(Components)
                .moveToElement(Tablets)
                .moveToElement(Software)
                .moveToElement(PhonePDAs)
                .moveToElement(Cameras)
                .moveToElement(MP3Players)
                .build()    // yukaridaki siralanan islemleri yapar.
                .perform(); // build edilen islemleri yapar

    }
    @Test
    public void hoverMenu(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);
        By menuItems = By.cssSelector("ul.nav>li");
        List<WebElement> menus = driver.findElements(menuItems);
        for (WebElement menu : menus) {
            new Actions(driver).moveToElement(menu).pause(100).perform();
        }
        driver.quit();
    }
    @Test
    public void hoverSubMenus(){
        String url = "http://opencart.abstracta.us/";
        driver.manage().window().maximize();
        driver.get(url);
        By menuItems = By.cssSelector("ul.nav>li");
        List<WebElement> menus = driver.findElements(menuItems);
        for (WebElement menu : menus) {
            new Actions(driver).moveToElement(menu).pause(100).perform();
            By subList =By.xpath(".//ul/li");
            List<WebElement>subMenus = menu.findElements(subList);
            if(subMenus.size()>0){
                for (WebElement subMenu : subMenus) {
                    new Actions(driver).moveToElement(subMenu).pause(100).perform();
                }
            }
        }
        driver.quit();
    }
}
