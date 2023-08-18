package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ActionClassDragDrop extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://testpages.herokuapp.com/styled/drag-drop-javascript.html";

    By lDragable1 = By.id("draggable1");
    By lDragable2 = By.id("draggable2");
    By lDroppable1 = By.id("droppable1");
    By lDroppable2 = By.id("droppable2");


    @Test
    public void drogDrop1(){

        driver.get(url);

        WebElement dragable1 = driver.findElement(lDragable1);
        WebElement dragable2 = driver.findElement(lDragable2);
        WebElement droppable1 = driver.findElement(lDroppable1);
        WebElement droppable2 = driver.findElement(lDroppable2);


        new Actions(driver)
                .clickAndHold(dragable1)
                .moveToElement(droppable1)
                .release()
                .build()
                .perform();

        driver.quit();
    }

    @Test
    public void drogDrop2(){

        driver.get(url);

        WebElement dragable1 = driver.findElement(lDragable1);
        WebElement dragable2 = driver.findElement(lDragable2);
        WebElement droppable1 = driver.findElement(lDroppable1);
        WebElement droppable2 = driver.findElement(lDroppable2);


        new Actions(driver)
                .clickAndHold(dragable1)
                .moveToElement(droppable1)
                .release()
                .pause(300)
                .clickAndHold(dragable2)
                .moveToElement(droppable2)
                .release()
                .build()
                .perform();

        driver.quit();
    }

    @Test
    public void drogDrop3(){

        driver.get(url);

        dragDrop(lDragable1, lDroppable1);

        dragDrop(lDragable2, lDroppable2);

        driver.quit();

    }

    public void dragDrop(By target, By destination){
        WebElement eTarget = wait.until(ExpectedConditions.visibilityOfElementLocated(target));
        WebElement eDest = wait.until(ExpectedConditions.visibilityOfElementLocated(destination));
        new Actions(driver)
                .dragAndDrop(eTarget, eDest)
                .perform();
    }


    @Test
    public void dragDrop4(){
        By lTarget = By.id("target");
        By lRed = By.xpath("//div[@id='source']/div[1]");
        By lGreen = By.cssSelector("#source div:nth-of-type(2)");
        By lBlue = By.cssSelector("#source div:nth-of-type(3)");

        driver.get("https://practice.expandtesting.com/drag-and-drop-circles");


        WebElement target = driver.findElement(lTarget);
        WebElement red = wait.until(ExpectedConditions.elementToBeClickable(lRed));
        WebElement green = driver.findElement(lGreen);
        WebElement blue = driver.findElement(lBlue);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('div.red').style.cursor = 'pointer';");

        new Actions(driver).clickAndHold(red)
                .pause(200)
                .moveToLocation(target.getLocation().x, target.getLocation().y+20)
                .pause(500)
                .build()
                .perform();

        sleep(10000);
        driver.quit();
    }





}
