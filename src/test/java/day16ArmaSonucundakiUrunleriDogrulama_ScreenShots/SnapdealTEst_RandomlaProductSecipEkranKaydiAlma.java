package day16ArmaSonucundakiUrunleriDogrulama_ScreenShots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class SnapdealTEst_RandomlaProductSecipEkranKaydiAlma {
    /**
     * watch aratin
     * listelenenler arasindan random bir ürün secin
     * o ürüne scroll edin
     * Ekran görüntüsü ve o ürünün görüntüsünü kaydedin
     */
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.snapdeal.com/";

    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() {
        driver.get(url);
        By lInput = By.cssSelector("#pushDenied");
        wait.until(ExpectedConditions.elementToBeClickable(lInput)).click();
        By lSearch = By.xpath("//input[@name='keyword'][1]");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(lSearch));
        Actions actions = new Actions(driver);
        actions
                .click(search)
                .sendKeys("watch")
                .keyDown(Keys.TAB)
                .keyDown(Keys.ENTER)
                .perform();

        // ürünleri listele
        By listOfProducts = By.cssSelector(".product-title");
        List<WebElement> productList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(listOfProducts));

        // Rastgele bir ürün seç
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement selectedProduct = productList.get(randomIndex);

        actions
                .scrollToElement(selectedProduct)
                .perform();

        takeScreenshot("MyWatchPage");
        takeScreenshot(selectedProduct, "MyWatch");
        selectedProduct.click();
    }

    public void takeScreenshot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".png";
        File target = new File("Screenshots/ " + fileName);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void takeScreenshot(WebElement element, String name) {
        File source = element.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".png";
        File target = new File("Screenshots/ " + fileName);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

