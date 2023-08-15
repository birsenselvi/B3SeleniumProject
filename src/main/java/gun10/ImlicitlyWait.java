package gun10;

import org.testng.annotations.Test;
import utils.BaseTestWithOutWait;
import utils.Driver;

import java.time.Duration;

public class ImlicitlyWait extends BaseTestWithOutWait {
    /*

        1.  Implicitly Wait
            driver bünyedindedir. Bu bekleme element presence oluncaya kadar her element icin beklenir.
            presence : var oluncaya kadar. Kodlarda olan element presence'dir.

        2.  Explicit wait
        3.  Fluent Wait

     */


    @Test
    public void test1(){
        driver = Driver.getDriver();
        // findElement ile aranan tüm elementler icin max 10 sn bekler
        // default olarak her yarim sn de bir kontrol eder
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
}
