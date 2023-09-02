package Scenerios_Stream;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class Scenarios extends BaseTest {
    /**
     *     Contact Name : adinizi girin
     *         Register'a tiklayin
     *         Veri girilmeyen fieldlarda hata oldugunu assert edin
     *
     *         Diger verileri doldurun
     *         Register'a tiklayin
     *
     *         "Thank you for validating your ticket" ya da baska bir locator ile sonucu assert edin
     */

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    String url = "https://practice.expandtesting.com/form-validation";

    By lInput = By.xpath("//input[@id = 'validationCustom01']");
    By lbutton = By.xpath("//button[@class='btn btn-primary']");//--//button[normalizespace(test())='Register']
    By ltext = By.cssSelector(".invalid-feedback");
    By lInput2 = By.id("validationCustom05"); //-- //form/div[2]/input
    By lSelect = By.cssSelector("#validationCustom04");
    By lDate = By.xpath("//input[@name='pickupdate']");
    By lConfirm = By.cssSelector("div[role='alert']>p");


    @Test
    public void test() {
        driver.get(url);


        driver.findElement(lInput).clear();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(lInput));
        input.sendKeys("Selvi");
        driver.findElement(lbutton).click();


        List<WebElement> textList = wait.until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(ltext));

        textList.forEach(e -> System.out.println(e.getText()));

        System.out.println("***");

        // stream
        long visibleElements = textList.stream()
                .filter(e -> e.isDisplayed())
                .count();

        Assert.assertEquals(visibleElements,3);




        WebElement input2 = driver.findElement(lInput2);
        input2.clear();
        input2.sendKeys("012-3456778");


        WebElement date = driver.findElement(lDate);
        date.clear();
        date.sendKeys("12.04.2019");


        WebElement select = driver.findElement(lSelect);
        Select slct = new Select(select);
        slct.selectByIndex(1);
        click(lbutton);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lConfirm));

        driver.quit();

        contains("Türkei", "i");
    }
    public void contains(String text, String textTosearch){

    }
}
