package gun14;

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

public class ActionClassMoveToElement extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

        /*
        Actions actions = new Actions(driver);  // actions tanimlamasi
        actions.moveToElement();                // belirtilen elemente
        actions.clickAndHold();
        actions.click();
        actions.pause();
        actions.dragAndDrop();
        actions.dragAndDropBy(, , );
        actions.sendKeys();
        actions.click();
        actions.keyDown();
        actions.keyUp();
        actions.doubleClick();
        actions.contextClick();
        actions.moveByOffset(, );
        actions.scrollByAmount(, );
        actions.scrollToElement();
        */


    @Test
    public void actionClass1(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By lDesktops = By.xpath("//a[text()='Desktops']");
        WebElement desktops = wait.until(ExpectedConditions.visibilityOfElementLocated(lDesktops));

        Actions actions = new Actions(driver);  // action tanimlaniyor
        actions
                .moveToElement(desktops)
                .pause(100)
                .build()        // build : yukaridaki siralanan islemleri built et
                .perform();     // build edilen islemleri yap
    }

    @Test
    public void actionClass2(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By lDesktops = By.xpath("//a[text()='Desktops']");

        hover(lDesktops);
    }


    @Test
    public void actionClass3_HoverMainMenu(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By menuItems = By.cssSelector("ul.nav > li");

        List<WebElement> menus = driver.findElements(menuItems);


        for (WebElement menu : menus) {
            new Actions(driver).moveToElement(menu).pause(200).perform();
        }

        driver.quit();
    }



    @Test
    public void actionClass4_HoverAllMenus(){
        String url = "http://opencart.abstracta.us/";
        driver.get(url);

        By menuItems = By.cssSelector("ul.nav > li");

        List<WebElement> menus = driver.findElements(menuItems);


        for (WebElement menu : menus) {
            new Actions(driver).moveToElement(menu).pause(200).perform();
            By subList = By.xpath(".//ul/li");

            List<WebElement> subMenus = menu.findElements(subList);
            if (subMenus.size()>0){
                for (WebElement subMenu : subMenus) {
                    new Actions(driver).moveToElement(subMenu).pause(100).perform();
                }
            }

        }

        driver.quit();
    }




}
