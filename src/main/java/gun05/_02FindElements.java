package gun05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _02FindElements extends BaseClass{

    String url = "http://opencart.abstracta.us/";

    @Test
    public void test_FindElements(){

        driver.get(url);

        // driver.findElement(locator)
        // eger locator sayfada yok ise hata verir
        // ayni locator'li birden fazla element varsa ilkini alir

        WebElement element1 = driver.findElement(By.tagName("H4"));
        System.out.println(element1.getText());

        // driver.findElements(locator)
        // ayni locator'li birden fazla element varsa hepsini bulur ve List olarak return eder.
        // eger locator sayfada yok ise null List return eder, hata vermez
        List<WebElement> elements = driver.findElements(By.tagName("H4"));
        System.out.println(elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        sleep(2000);
        driver.quit();
    }
}
