package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

public class SelectBoxTest {
    /*
        1.  https://the-internet.herokuapp.com/dropdown
        2.  dropdown'un options.larinin textlerini consola yazdirin
        3.  siradan tüm optionlari 1 sn ara vererek secin
        4.  value degeri 1 olani secin
        5.  visible texti Option 2 olani secin
     */

    WebDriver driver = Driver.getDriver();

    @Test
    public void dropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dd = new Select(driver.findElement(By.cssSelector("#dropdown")));

        for (WebElement option : dd.getOptions()) {
            System.out.println(option.getAttribute("value") + " : " + option.getText());
        }

        for (int i = 0; i < dd.getOptions().size(); i++) {
            if (dd.getOptions().get(i).getAttribute("disabled") == null)
                dd.selectByIndex(i);

            Utils.sleep(1000);
        }

        dd.selectByValue("1");
        Utils.sleep(1000);
        dd.selectByVisibleText("Option 2");
        Utils.sleep(1000);

        driver.quit();
    }
}
