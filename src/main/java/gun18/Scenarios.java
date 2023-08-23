package gun18;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class Scenarios extends BaseTest {

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void test1() {

    /*
        https://practice.expandtesting.com/form-validation
        Contact Name : adinizi girin
        Register'a tiklayin
        Veri girilmeyen fieldlarda hata oldugunu assert edin

        Diger verileri doldurun
        Register'a tiklayin

        "Thank you for validating your ticket" ya da baska bir locator ile sonucu assert edin

     */

    }


    @Test
    public void test2() {
        String url = "https://demoqa.com/automation-practice-form";

        driver.get(url);

        // sayfanin zoom ayarlamasi
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%'");
    }

    public static void main(String[] args) throws AWTException {

        // bir text'i Clipboarda kaydetmek icin (Text secip Ctrl-C yapmak gibi)
        // Ctrl-V ile paste edilir
        StringSelection ss = new StringSelection("D:\\Users\\IdeaProjects\\GuiderSoft\\e2etestautomation\\src\\main\\java\\gun18\\CookieTest.java");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }
}