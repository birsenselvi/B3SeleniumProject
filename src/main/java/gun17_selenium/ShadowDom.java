package gun17_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ShadowDom extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html";

    @Test
    public void test1(){
        By locatorP = By.xpath("");

        driver.get(url);

        // shadow dom, web sayfasinda locator bulamayabilirsiniz
        // direkt ulasilamaz
        // shadow root elemeti bulunur
        By shadowRootElement = By.cssSelector("#content");

        // shadow-root altindaki elementlere ulasmak icin
        // root-element bulunur ve getShadowRoot() ile cözülür
        // shadow-root altindaki element aranir
        WebElement p = driver
                .findElement(shadowRootElement)
                .getShadowRoot()
                .findElement(By.cssSelector("p"))
                ;
        String text = p.getText();
        System.out.println(text);
        driver.quit();
    }

}
