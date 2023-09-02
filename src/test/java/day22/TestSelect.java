package day22;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelect {
    WebDriver driver;
    WebDriverWait wait;

    String url="https://jqueryui.com/selectable/";

    @FindBy(linkText = "Display as grid")
    WebElement displayASGrid;


    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Test
    public void test(){

        driver.get(url);

        displayASGrid.click();
        driver.switchTo().frame(0);

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
                .pause(100)
                .keyUp(Keys.CONTROL)
                .perform();


    }
    @Test(dependsOnMethods = {"test"})
    public void test1() {

        int[] arr = {1, 3, 5, 7, 9, 11};
        for (int i : arr) {
            new Actions(driver)
                    .keyDown(Keys.CONTROL)
                    .click(num(i))
                    .pause(100)
                    .keyUp(Keys.CONTROL)
                    .perform();
        }

    }
    @Test(dependsOnMethods = {"test"})
    public void test2() {

        int[] arr = {1, 3, 5, 7, 9, 11};
        keyDown(Keys.CONTROL);
        for (int i : arr) {

            click(i);

        }
        keyUp(Keys.CONTROL);
    }
    void click(int i){
        new Actions(driver).click(num(i)).perform();
    }


    WebElement num(int num){
      return  driver.findElement(By.xpath("//ol[@id ='selectable']/li[text()='" + num + "']"));

    }
    void keyDown(Keys key){
        new Actions(driver).keyDown(key).perform();
    }
    void keyUp(Keys key){
        new Actions(driver).keyUp(key).perform();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
