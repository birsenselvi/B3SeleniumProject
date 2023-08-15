package gun10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.Utils;

import java.util.List;

public class CheckBoxTest {
    /*
        1.  https://the-internet.herokuapp.com/checkboxes
        2.  her iki checkbox'in valuesunu consola yazdirin
        3.  tikli olmayani tiklatin
        4.  her iki checkbox'in valuesunu consola yazdirin
     */



    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();

        String url = "https://the-internet.herokuapp.com/checkboxes";

        driver.get(url);

        By lCheckBoxes = By.cssSelector("#checkboxes input");
        //By lCheckBoxes = By.cssSelector("input[type='checkbox']");
        //By lCheckBoxes = By.xpath("//input[@type='checkbox']");

        List<WebElement> cbs = driver.findElements(lCheckBoxes);
        for (WebElement cb : cbs) {
            System.out.println(cb.getAttribute("checked"));
        }

        for (WebElement cb : cbs) {
            if (cb.getAttribute("checked") == null)
                cb.click();
        }

        for (WebElement cb : cbs) {
            System.out.println(cb.getAttribute("checked"));
        }

        Utils.sleep(4000);
        driver.quit();

    }
}
