package day15_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class test2_Actions extends BaseTest {
    {
    driver = utils.Driver.getDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
    String url = "http://opencart.abstracta.us/";
    @Test
    public void testt(){
        driver.get(url);
        By lInput = By.cssSelector("#search>input");
        By lMac = By.cssSelector(".caption>h4");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lInput));
        List<WebElement>listText = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lMac));

        new Actions(driver)
                .click(input)
                .sendKeys(input, "maa")
                .keyDown(Keys.BACK_SPACE)
                .sendKeys("c")
                .keyDown(Keys.TAB)// tab a basarak locater bulmadan ara tusuna basilabilir
                .keyDown(Keys.ENTER)
                .build()
                .perform();

        listText.forEach(e-> Assert.assertTrue(e.getText().toLowerCase().contains("mac")));

        driver.quit();

    }
}
