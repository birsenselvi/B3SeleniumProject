package gun22_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Utils;

import java.time.Duration;

public class TestSelectable extends BaseTest {

    String url = "https://jqueryui.com/selectable";

    By lDisplayAsGrid = By.linkText("Display as grid");


    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown(){
        Utils.sleep(3000);
        driver.quit();
    }

    @Test
    public void start(){
        driver.get(url);
        driver.findElement(lDisplayAsGrid).click();
        driver.switchTo().frame(0);
    }

    @Test(dependsOnMethods = {"start"})
    public void testSelect(){
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(num(1))
                .pause(100)
                .click(num(3))
                .pause(100)
                .click(num(5))
                .pause(100)
                .click(num(7))
                .pause(100)
                .click(num(9))
                .pause(100)
                .click(num(11))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

    @Test(dependsOnMethods = {"start"})
    public void testSelect2(){
        int[] arr = {1, 2, 5, 6, 7};

        for (int i : arr) {
            new Actions(driver)
                    .keyDown(Keys.CONTROL)
                    .click(num(i))
                    .pause(100)
                    .keyUp(Keys.CONTROL)
                    .build()
                    .perform();
        }

    }

    @Test(dependsOnMethods = {"start"})
    public void testSelect3(){
        int[] arr = {1, 2, 5, 6, 7};
        keyDown(Keys.CONTROL);
        for (int i : arr) {
            click(i);
        }
        keyUp(Keys.CONTROL);
    }

    @Test(dependsOnMethods = {"start"})
    public void testSelect4(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        sayiSec(arr);
    }

    public void sayiSec(int...arr){
        keyDown(Keys.CONTROL);
        for (int i : arr) {
            click(i);
        }
        keyUp(Keys.CONTROL);
    }


    void keyDown(Keys key){
        new Actions(driver).keyDown(key).perform();
    }

    void keyUp(Keys key){
        new Actions(driver).keyUp(key).perform();
    }

    void click(int i){
        new Actions(driver).click(num(i)).perform();
    }

    WebElement num(int num){
        return driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='" + num + "']"));
    }

}
