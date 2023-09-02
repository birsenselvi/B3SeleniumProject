package Kod;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class script extends BaseTest {

    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        driver.get("https://demoqa.com/sortable ");
        List<WebElement> sayiList=driver.findElements(By.xpath("//*[@id='demo-tabpane-list']/div/div"));
        WebElement one=driver.findElement(By.xpath("//div[@class='fade tab-pane active show']//div[text()='One']"));
        Actions actions = new Actions(driver);


        for (int i = 0; i < sayiList.size()-1; i++) {
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", one); // elementlerden birisini script ile buldurmaliyiz
            actions.dragAndDrop(sayiList.get(sayiList.size()-1), sayiList.get(i)).perform();
        }

        //driver.quit();

    }
        }




