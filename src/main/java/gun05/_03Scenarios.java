package gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03Scenarios extends BaseClass{

    @Test
    public void odev2(){
        //1. http://opencart.abstracta.us/
        driver.get("http://opencart.abstracta.us/");

        //2. "imac" search edin
        String searchText = "imac";
        sendkeys(By.name("search"), searchText, Keys.ENTER);

        //3. imac ürününün sayfaya geldigini assert edin.
        String iMacText = driver.findElement(By.tagName("h4")).getText();

        Assert.assertTrue(iMacText.equalsIgnoreCase(searchText));

        driver.quit();
    }


    @Test
    public void odev3(){

        String url = "http://uitestingplayground.com/";
        By lTextInput = By.linkText("Text Input");
        By lInput = By.id("newButtonName");
        By lButton = By.id("updatingButton");

        // http://uitestingplayground.com/

        // "Text Input" linkine tiklayin

        // inputbox'a bir text girin

        // alttaki butona tiklayin

        // butonun text'inin girdiginiz text ildigunu assert edin

    }
}
