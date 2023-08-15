package gun12;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import static gun12.AlertsLocators.*;

public class Alerts extends BaseTest {



    @Test
    public void test_Alert1(){
        driver = Driver.getDriver();

        driver.get(url);
        click(lAlertButton);

        Alert alert = driver.switchTo().alert();
        /*
            alert.sendKeys();   -> confirm alertine text gönderir
            alert.dismiss();    -> cancel butonuna tiklar
            alert.accept();     -> OK butonuna tiklar
            alert.getText();    -> alertin textini getirir
         */
        alert.accept();
        sleep(2000);

        scrollIntoView(lConfirmButton);
        click(lConfirmButton);
        sleep(2000);
        driver.quit();
    }


    @Test
    public void test_AlertTimer(){
        driver = Driver.getDriver();

        driver.get(url);
        click(lTimerAlertButton);

        wait.until(ExpectedConditions.alertIsPresent()).accept();

        sleep(5000);
        driver.quit();
    }

    @Test
    public void test_AlertConfirm(){
        driver = Driver.getDriver();

        driver.get(url);

        sleep(5000);
        driver.quit();
    }

    @Test
    public void test_AlertPrompt(){
        driver = Driver.getDriver();

        driver.get(url);


        sleep(5000);
        driver.quit();
    }

}
