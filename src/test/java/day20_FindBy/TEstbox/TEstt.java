package day20_FindBy.TEstbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TEstt {
    WebDriver driver;
    TEstBoxPAge tb;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void test(){

        tb = new TEstBoxPAge(driver);
        tb.gotoSite();
        tb.sendKeys(tb.userName, "selvi");
        tb.sendKeys(tb.userEmail, "sss@gmail.com");
        tb.sendKeys(tb.currentAddress,"Flensburg");
        tb.sendKeys(tb.permanentAddress,"Flensburg");
        tb.click(tb.button);
        tb.assertisDisplayed(tb.output);


    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}
