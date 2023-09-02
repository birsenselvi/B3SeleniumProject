package birsenselviCoskun.aufgabe15;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class _03 extends BaseTest {
    /**
     *     https://demoqa.com/slider   sayfasina gidin
     *     Kaydirma cubugu üzerindeki butonu slider degeri
     *     70 den büyük oluncaya kadar action class kullanarak kaydirin
     */
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    String url = "https://demoqa.com/slider ";
    @Test
    public void test(){
        driver.get(url);

    }

}
