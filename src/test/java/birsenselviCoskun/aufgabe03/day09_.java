package birsenselviCoskun.aufgabe03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class day09_ {
    /**
     *   Remove butonuna tikla
     *   checkbox'in invisible oldugunu assert et.
     *
     *   "Add" butonuna tikla
     *   checkbox'in visible oldugunu assert et.
     *
     *
     *    Enable butonuna tikla
     *    inputbox'in enable olmasini bekle
     *
     *
     *    Disable butonuna tikla
     *    inputbox'in disable olmasini bekle
     */
    WebDriver driver;
    String url ="https://the-internet.herokuapp.com/dynamic_controls";
    @Test
    public void test3(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(300));
        driver.get(url);
        /**
         *  Remove butonuna tikla
         *  checkbox'in invisible oldugunu assert et.
         */
        By lRemoveButton = By.xpath("//button[text()='Remove']");
        driver.findElement(lRemoveButton).click();
        By lCheckBox = By.xpath("//input[@type='checkbox']");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(lCheckBox));

        /**
         *  "Add" butonuna tikla
         *  checkbox'in visible oldugunu assert et.
         */
        By lAddButton = By.xpath("//button[text()='Add']");
        driver.findElement(lAddButton).click();
        By lCheckboxVisible = By.cssSelector("p#message");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lCheckboxVisible));

        /**
         *  Enable butonuna tikla
         *  inputbox'in enable olmasini bekle
         */

        By lEnableButton = By.xpath("//button[text()='Enable']");
        driver.findElement(lEnableButton).click();
        By lInputboxEnable = By.cssSelector("p#message");
        wait.until(ExpectedConditions.textToBe(lInputboxEnable,"It's enabled!"));

        /**
         *   Disable butonuna tikla
         *   inputbox'in disable olmasini bekle
         */

        By lDisableButton = By.xpath("//button[text()='Disable']");
        driver.findElement(lDisableButton).click();
        By lInputBoxDisable = By.cssSelector("p#message");
        wait.until(ExpectedConditions.textToBe(lInputBoxDisable,"It's disabled!"));














        driver.quit();

    }
}
