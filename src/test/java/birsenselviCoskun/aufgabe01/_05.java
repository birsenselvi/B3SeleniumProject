package birsenselviCoskun.aufgabe01;

import org.testng.annotations.Test;

/**
 * 1.  https://testpages.herokuapp.com/styled/index.html
 * 2.  "HTML Form Example" lnkine tiklayin
 * 3.  Acilan formda username ve password alanlarini doldurunuz
 * 4.  submit butonuna tiklayin
 * 5.  acilan sayfada girdiginiz verilerin yazildigini assert edin
 */

public class _05 extends BaseClass {
    String url = "https://testpages.herokuapp.com/styled/index.html";
    @Test
    public void Testing(){

        driver.manage().window().maximize();
        driver.get(url);

        // "HTML Form Example" lnkine tiklayin

        sleep();
        driver.quit();

    }
}
