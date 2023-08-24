package gun19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

public class TestNG_2Sample {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    /*
        TestNG de test methodlarina priority veya dependency verilmez ise
        siralama method isimlerine göredir
        Priority : -5000 +5000, en düsük olan en önce calisir
        default priority 0 dir
     */
    @Test(testName = "T3", description = "bu bir test methodudur")
    public void test3(){
        driver.get("https://google.com");
    }

    @Test(testName = "T2", priority = 2, enabled = false)
    public void test2(){
        driver.get("https://yahoo.com");
    }




    @AfterClass
    public void afterClass(){
        Utils.sleep(3000);
        driver.quit();
    }


}
