package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _aufgabe extends gun05_selenium.BaseClass {
    String url = "http://opencart.abstracta.us/";
    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get(url);

        String searchText = "imac";
        sendkeys(By.name("search"),searchText,Keys.ENTER);

        String iMacText = driver.findElement(By.tagName("h4")).getText();
        Assert.assertTrue(iMacText.equalsIgnoreCase(searchText));

        sleep(1000);
        driver.quit();

    }
}
