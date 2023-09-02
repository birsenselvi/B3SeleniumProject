package birsenselviCoskun.aufgabe01;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *    http://uitestingplayground.com/
 *    "Text Input" linkine tiklayin
 *     inputbox'a bir text girin
 *     alttaki butona tiklayin
 *     butonun text'inin girdiginiz text ildigunu assert edin
 */

public class _03 extends BaseClass {

    String url = "http://uitestingplayground.com/";
    By lTextInput = By.linkText("Text Input");
    By lInput= By.id("newButtonName");
    By lButton = By.id("updatingButton");
    @Test
    public void Test(){

        // http://uitestingplayground.com/

        driver.manage().window().maximize();
        driver.get(url);

        // "Text Input" linkine tiklayin

        driver.findElement(lTextInput).click();

        // inputbox'a bir text girin, alttaki butona tiklayin

        driver.findElement(lInput).sendKeys("Button");
        driver.findElement(lButton).click();

        // butonun text'inin girdiginiz text ildigunu assert edin

        Assert.assertTrue(driver.findElement(lButton).getText().equalsIgnoreCase("Button"));

        sleep(3000);
        driver.quit();

    }
}
