package gun06;

import gun05.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Tests01 extends BaseClass {

    @Test
    public void test1() {
        // http://opencart.abstracta.us/ adresteki
        // toplam a elementlerinin sayisi kactir
        // textlerini consola
        driver.get("http://opencart.abstracta.us/");
        By aElementsCss = By.cssSelector("a");
        By aElementsXpath = By.xpath("//a");

        //WebElement element = driver.findElement(aElementsCss);

        List<WebElement> elements = driver.findElements(aElementsCss);

        System.out.println("Sayfadaki a elementi sayisi : " + elements.size());
        for (WebElement element : elements) {
            if (element.getText().length() > 0)
                System.out.println(element.getText());
        }


        driver.quit();
    }

    @Test
    public void test2() {
        driver.get("http://opencart.abstracta.us/");
        By aElementsXpath = By.xpath("//a");

        List<WebElement> elements = driver.findElements(aElementsXpath);

        List<WebElement> newList =
                elements
                        .stream()
                        .filter(e -> e.getText().length() > 0)
                        .collect(Collectors.toList());

        System.out.println("Sayfadaki a elementi sayisi : " + newList.size());
        newList.forEach(e-> System.out.println(e.getText()));


        driver.quit();
    }

    @Test
    public void test3() {
        //1. http://opencart.abstracta.us/
        //2. searcbox'a "Macbook" yazip, search butonuna tiklayin
        //3. Macbook ürününün sayfaya geldigini assert edin.            h4 > a

        driver.get("http://opencart.abstracta.us/");
        By searchInput = By.cssSelector("#search input");
        By searchButton = By.cssSelector("#search button");
        //driver.findElement(searchInput).sendKeys("MackBook");
        sendkeys(searchInput, "MacBook");

        //driver.findElement(searchButton).click();
        click(searchButton);

        By macBook = By.xpath("//h4//a[text()='MacBook']");

        driver.findElement(macBook);

        driver.quit();
    }
}
