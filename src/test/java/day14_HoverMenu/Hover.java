package day14_HoverMenu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;

public class Hover extends BaseTest {
    {
        driver= utils.Driver.getDriver();
        driver.manage().window().maximize();
    }
    String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
    @Test
    public void mausOver(){
        driver.get(url);

        By lSymbols = By.xpath("//div[@class = 'figure text-center col-3 py-2']");

        List<WebElement> smbls = driver.findElements(lSymbols);

        for (WebElement symbol : smbls) {
            new Actions (driver).moveToElement(symbol).pause(100).perform();
            By symbolText = By.xpath("//./div/p[text()]"); // . (dot) --> means active element.

            List<WebElement>texts = symbol.findElements(symbolText);
            for (WebElement t :texts) {
                System.out.println(t.getText());
            }
        }
        driver.quit();

    }

    }


