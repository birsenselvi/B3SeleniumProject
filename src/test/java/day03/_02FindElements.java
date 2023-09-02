package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _02FindElements extends gun05_selenium.BaseClass {
    String url = "http://opencart.abstracta.us/";

    @Test
    public void test_FindElements(){
        driver.get(url);

        // driver.findElement(locator)
        // locator sayfada yok ise hata verir.
        // birden fazla ayni locator li element varsa, ilkini alir-

        WebElement element1 = driver.findElement(By.tagName("H4"));
        System.out.println(element1.getText());

        // ayni locatorli birden fayla element varsa hepsini bulur ve list olarak return eder.
        // eger locator sayfada yok ise null list return eder, hata vermez.

        List<WebElement> elements = driver.findElements(By.tagName("H4"));
        System.out.println(elements.size());
        for (WebElement element:elements) {
            System.out.println(element.getText());

        }

        sleep(3000);
        driver.quit();
    }
}
