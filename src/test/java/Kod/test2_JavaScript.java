package Kod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class test2_JavaScript extends BaseTest {

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test2(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions = new Actions(driver);
        List<WebElement> BaskentList = driver.findElements(By.xpath("//div[@id='dropContent']//div[@class='dragableBox'][not(@style)]"));
        List<WebElement> UlkeList = driver.findElements(By.xpath("//div[@class='dragableBoxRight']"));

        WebElement Rome = driver.findElement(By.xpath("(//div[text()='Rome'])[2]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Rome);

        actions
                .clickAndHold(BaskentList.get(0)).moveToElement(UlkeList.get(2)).release()
                .clickAndHold(BaskentList.get(1)).moveToElement(UlkeList.get(5)).release()
                .clickAndHold(BaskentList.get(2)).moveToElement(UlkeList.get(6)).release()
                .clickAndHold(BaskentList.get(3)).moveToElement(UlkeList.get(3)).release()
                .clickAndHold(BaskentList.get(4)).moveToElement(UlkeList.get(4)).release()
                .clickAndHold(BaskentList.get(5)).moveToElement(UlkeList.get(0)).release()
                .clickAndHold(BaskentList.get(6)).moveToElement(UlkeList.get(1)).release()
                .perform();

        List<WebElement> sonHal= driver.findElements(By.xpath("//div[@id='countries']//div[@class='dragableBox']"));


        for (int i = 0; i < sonHal.size(); i++) {
            Assert.assertTrue(sonHal.get(i).getCssValue("background-color").equalsIgnoreCase("rgba(0, 255, 0, 1)"));

        }

    }
}
