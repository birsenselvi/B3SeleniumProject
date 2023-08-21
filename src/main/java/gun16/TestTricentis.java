package gun16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TestTricentis {


    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // locators
    String url = "https://demowebshop.tricentis.com/";

    By lSearchBox = By.id("small-searchterms");
    By lSearchButton = By.cssSelector(".search-box input[value=\"Search\"]");
    By lSearchResult = By.xpath("//div[@class='search-results']");
    By lProductItems = By.xpath(".//div[@class='item-box']");
    //By searchResults = By.cssSelector(".search-results > div > div");



    @Test
    public void test1() throws IOException {

        // ana sayfaya gidin
        open(url);

        // sayfanin title'inin "Demo Web Shop" oldugunu assert edin
        String title = "Demo Web Shop";
        Assert.assertEquals(driver.getTitle(), title);


        //comp kelimesi ile arama yapin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(lSearchButton)).click();

        // search result bekleniyor
        WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(lSearchResult));

        // Listelenen ürün sayisinin 7 oldugunu assert edin
        List<WebElement> results = searchResult.findElements(lProductItems);
        Assert.assertEquals(results.size(), 7);


        // cart'a ekleneilecek ürün sayisinin 6 aoldugunu assert edin
        List<WebElement> resultsWithAddToCart = new ArrayList<>();
        for (WebElement result : results) {
            try {
                By atc = By.xpath(".//input[@value='Add to cart']");
                result.findElement(atc);
                resultsWithAddToCart.add(result);
            }catch (Exception ignored){}
        }

        /*
        for (WebElement result : results) {
            By atc = By.xpath(".//input[@value='Add to cart']");
            if (result.findElements(atc).size()>0)
                resultsWithAddToCart.add(result);
        }
         */

        System.out.println(resultsWithAddToCart.size());

        // sayfanin resmini ekran görüntüsünü alin
        //JavascriptExecutor js = (JavascriptExecutor) driver;

        // driver ekran görüntüsünü almak icin ayarlandi
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // driver'in alacagi ekran görüntüsü source adi altinda kaydedildi.
        File source = screenshot.getScreenshotAs(OutputType.FILE);

        // diske kaydedecegimiz dosya adi
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name = "Resim_" + now + ".png";
        File target = new File("screenshots/" + name);

        // FileUtils  driver'in aldigi ekran görüntüsünü (source), target'a yazar
        FileUtils.copyFile(source, target);


        WebElement firstPoduct =  searchResult.findElement(By.xpath(".//div[@class='item-box'][1]"));

        // elementin ekran görüntüsü sourceProduct adi altinda kaydedildi.
        File sourceProduct = firstPoduct.getScreenshotAs(OutputType.FILE);
        // diske kaydedecegimiz dosya adi
        File targetProduct = new File("screenshots/resimProduct.png");

        // FileUtils  elementin ekran görüntüsünü (sourceProduct), targetProduct'a yazar
        FileUtils.copyFile(sourceProduct, targetProduct);


        Utils.sleep(3000);
        driver.quit();
    }

    public void open(String url){
        driver.get(url);
    }
}
