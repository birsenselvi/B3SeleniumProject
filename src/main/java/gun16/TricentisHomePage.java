package gun16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*  POM : Page Object Model denir
    Her sayfa icin ayri bir class olusturulur
    O sayfayanin locatorlari ve kullanilacak methodlar o class icinde olur
*/
public class TricentisHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Variables, locators
    private String url = "https://demowebshop.tricentis.com/";
    private By lSearchBox = By.id("small-searchterms");
    private By lSearchButton = By.cssSelector(".search-box input[value=\"Search\"]");
    private By lSearchResult = By.xpath("//div[@class='search-results']");
    private By lProductItems = By.xpath(".//div[@class='item-box']");
    //By searchResults = By.cssSelector(".search-results > div > div");



    public TricentisHomePage(){
        this(Driver.getDriver());
    }

    public TricentisHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void maximize(){
        driver.manage().window().maximize();
    }

    public void checkTitle(String title){
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void search(String textToSearch){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(lSearchButton)).click();
    }

    public List<WebElement> getProductList(){
        WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(lSearchResult));
        return searchResult.findElements(lProductItems);
    }

    public void takeScreenShot(){
        takeScreenShot("Screenshot");
    }

    public void takeScreenShot(String imageName){
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name = imageName + "_" + now + ".png";
        File target = new File("screenshots/" + name);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void takeElementScreenShot(WebElement element){
        File source = element.getScreenshotAs(OutputType.FILE);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name = "ScreenshotElement_" + now + ".png";
        File target = new File("screenshots/" + name);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void open(){
        driver.get(url);
    }
}
