package birsenselviCoskun.aufgabe01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *   http://opencart.abstracta.us/
 *  "imac" search edin
 *   imac ürününün sayfaya geldigini assert edin.
 */

public class _02 extends BaseClass {

    String url = "http://opencart.abstracta.us/";
    @Test
    public void Test(){

        driver.manage().window().maximize();
        driver.get(url);

        String searchText = "imac";

        sendKeys(By.name("search"),searchText, Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase(searchText));


        sleep(3000);
        driver.quit();
    }


}
