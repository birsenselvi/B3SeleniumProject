package gun16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class SnapdealTest {
    /*
        https://www.snapdeal.com/
        watch aratin
        listelenenler arasindan random bir ürün secin
        o ürüne scroll edin
        Ekran görüntüsü ve o ürünün görüntüsünü kaydedin

     */

    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://www.snapdeal.com/";
    @Test
    public void test(){
        driver.get(url);
    }
}
