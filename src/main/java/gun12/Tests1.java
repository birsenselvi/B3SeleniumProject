package gun12;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

public class Tests1 extends BaseTest {


    @Test
    public void clickButons1(){
        driver = Driver.getDriver();

        String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
        driver.get(url);

        By[] locators = {
                By.cssSelector("#button00"),
                By.cssSelector("#button01"),
                By.cssSelector("#button02"),
                By.cssSelector("#button03")
        };

        for (int i = 0; i < locators.length; i++) {
            click(locators[i]);
        }

        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");

        driver.quit();

    }
}
