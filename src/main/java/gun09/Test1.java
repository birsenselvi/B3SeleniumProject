package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

import java.util.List;

public class Test1 {

    WebDriver driver;

    @Test
    public void test1(){
        // utils package'sinin altindaki Driver class'inda bulunan
        // static getDriver() methodu ile driver olusturuldu.
        driver = Driver.getDriver("edge");
        driver.get("https://google.com");

        driver = Driver.getDriver("edge");
        driver.get("https://yahoo.com");

        driver = Driver.getDriver();
        driver.get("https://google.com");


    }

    @Test
    public void test2(){
        /*
            https://practice.expandtesting.com/login
            username ve password girin
            login butonunun background-color'ini consola yazdirin
            login butonuna tiklayin

            login oldugunuzu "Secure Area" yazisi ya da "logout" linki ile assert edin

            logout'a tiklayin

            "Login Page" yazisi ya da login butonu ile ciktiginizi assert edin

         */
    }

    @Test
    public void testSelectBox(){
        driver = Driver.getDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        WebElement selectElement = driver.findElement(By.cssSelector("select[name='dropdown']"));
        Select select = new Select(selectElement);

        // select elementinin 3 indexli optionini secer
        select.selectByIndex(3);
        Utils.sleep(2000);

        // select elementinin valuesu "dd6" olan option'ini secer
        select.selectByValue("dd6");
        Utils.sleep(2000);

        // select elementinin görünen texti "Drop Down Item 1" olan option'ini secer
        select.selectByVisibleText("Drop Down Item 1");

        System.out.println("select.isMultiple() = " + select.isMultiple());

        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        Driver.quit();
    }

    @Test
    public void elementInElement(){
        driver = Driver.getDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        By lForm = By.cssSelector("#HTMLFormElements");
        WebElement form = driver.findElement(lForm);

        By lInput = By.xpath(".//input[@type='text']");


        //driver.findElement(lInput).sendKeys("name");

        // element altinda element bulurken xpath kullaniliyor ise
        // xpathin basina . eklenir, . = current element
        form.findElement(lInput).sendKeys("name");


        driver.findElement(By.id(""))
                .findElement(By.cssSelector(""))
                .findElement(By.xpath(".//"))
                .findElements(By.tagName("a"));

    }



}
