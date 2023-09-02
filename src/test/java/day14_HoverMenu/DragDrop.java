package day14_HoverMenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class DragDrop extends BaseTest {
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
    }
    String url = "https://practice.expandtesting.com/drag-and-drop-circles";
    @Test
    public void clickHold(){
        driver.get(url);
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        By lred = By.xpath(".//div[@class='red']");
        WebElement red = driver.findElement(lred);

        By lgreen = By.xpath(".//div[@class='green']");
        WebElement green = driver.findElement(lgreen);

        By lblau = By.xpath(".//div[@class='blue']");
        WebElement blau = driver.findElement(lblau);

        By ltarget = By.xpath(".//div[@id='target']");
        WebElement target = driver.findElement(ltarget);
        By lLocator = By.xpath(".//div[@draggable = 'true']");

       new Actions(driver)

               .clickAndHold(red)
               .moveToElement(target)
               .release(red)
               .perform();
       wait.until(ExpectedConditions.visibilityOfElementLocated(lLocator));



    }
    public void dragDrop(By target, By destination){
        WebElement eTArget = wait.until(ExpectedConditions.visibilityOfElementLocated(target));
        WebElement eDestination = wait.until(ExpectedConditions.visibilityOfElementLocated(destination));
        new Actions(driver)
                .dragAndDrop(eTArget,eDestination)
                .perform();
    }
}
