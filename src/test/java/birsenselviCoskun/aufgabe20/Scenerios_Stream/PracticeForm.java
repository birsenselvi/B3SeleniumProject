package birsenselviCoskun.aufgabe20.Scenerios_Stream;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PracticeForm extends BaseTest {
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() {
        driver.get("https://demoqa.com/automation-practice-form");
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='50%'");
        By lFirst = By.cssSelector("#firstName");
        WebElement first = driver.findElement(lFirst);
        Actions actions = new Actions(driver);
        actions
                .moveToElement(first)
                .sendKeys("Selvi")
                .keyDown(Keys.TAB)
                .sendKeys("Coskun")
                .keyDown(Keys.TAB)
                .sendKeys("name@asdf.com")
                .keyDown(Keys.TAB)
                .keyDown(Keys.ARROW_RIGHT)
                .keyDown(Keys.ENTER)
                .keyDown(Keys.TAB)
                .sendKeys("12345678")
                .keyDown(Keys.TAB)
                .perform();
        selectDate("2014", "May","12");

    }
    public void selectDate(String yil, String ay, String gun){
        By lYil = By.cssSelector(".react-datepicker__year-select");
        WebElement yll = driver.findElement(lYil);
        Select select = new Select(yll);
        select.selectByValue(yil);
        By lAy = By.xpath("//select[1]");
        WebElement ayy = driver.findElement(lAy);
        Select select1 = new Select(ayy);
        select1.selectByValue(ay);

    }

}
