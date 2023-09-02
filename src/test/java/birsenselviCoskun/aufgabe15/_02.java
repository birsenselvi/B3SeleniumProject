package birsenselviCoskun.aufgabe15;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class _02 extends BaseTest {
    /**
     *     http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
     *     sayfasinda solda listeklenen baskentleri sagda listelenen ülkelerle eslestirin.
     *     Eslesme dogru olmali. Dogru eslestirme yapunca baskent'in zemin rengi degismektedir.
     */ {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";

    @Test
    public void test() {
        driver.get(url);
        By lOslo = By.cssSelector("#box1");
        WebElement oslo = driver.findElement(lOslo);
        By lStockholm = By.cssSelector("#box2");
        WebElement stockholm = driver.findElement(lStockholm);
        By lWashington = By.cssSelector("#box3");
        WebElement washington = driver.findElement(lWashington);
        By lCopenhagen = By.cssSelector("#box4");
        WebElement copenhagen = driver.findElement(lCopenhagen);
        By lSeoul = By.cssSelector("#box5");
        WebElement seoul = driver.findElement(lSeoul);
        By lRome = By.cssSelector("#box6");
        WebElement rome = driver.findElement(lRome);
        By lMadrid = By.cssSelector("#box7");
        WebElement madrid = driver.findElement(lMadrid);

        By lNorway = By.cssSelector("#box101");
        WebElement norway = wait.until(ExpectedConditions.visibilityOfElementLocated(lNorway));
        By lSweden = By.cssSelector("#box102");
        WebElement sweden = wait.until(ExpectedConditions.visibilityOfElementLocated(lSweden));
        By lUnitedStates = By.cssSelector("#box103");
        WebElement united = wait.until(ExpectedConditions.visibilityOfElementLocated(lUnitedStates));
        By lDenMark = By.cssSelector("#box104");
        WebElement denmark = wait.until(ExpectedConditions.visibilityOfElementLocated(lDenMark));
        By lSouthKorea = By.cssSelector("#box105");
        WebElement south = wait.until(ExpectedConditions.visibilityOfElementLocated(lSouthKorea));
        By lItaly = By.cssSelector("#box106");
        WebElement italy = wait.until(ExpectedConditions.visibilityOfElementLocated(lItaly));
        By lSpanien = By.cssSelector("#box107");
        WebElement spanien = wait.until(ExpectedConditions.visibilityOfElementLocated(lSpanien));

        new Actions(driver)
                .dragAndDrop(oslo, norway)
                .dragAndDrop(stockholm, sweden)
                .dragAndDrop(washington, united)
                .dragAndDrop(copenhagen, denmark)
                .dragAndDrop(seoul, south)
                .dragAndDrop(rome, italy)
                .dragAndDrop(madrid, spanien)
                .build()
                .perform();
        driver.quit();
    }
}

