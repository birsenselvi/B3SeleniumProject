package gun21_testng.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestDemoBlaze {

    WebDriver driver;
    WebDriverWait wait;

    Locators locators;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // PageFactory'e Locators.class'indaki elementleri initialize ettiriyoruz
        locators = PageFactory.initElements(driver, Locators.class);
        //locators = new Locators(driver);
    }


    @AfterTest
    public void afterTest(){
        Utils.sleep(2000);
        driver.quit();
    }


    @Test
    public void test1(){
        driver.get(locators.url);
        locators.phonesLink.click();
        Utils.sleep(2000);
        System.out.println("locators.productNames.size() = " + locators.productNames.size());

        List<WebElement> pNames = new ArrayList<>(locators.productNames);
        System.out.println("1pNames.size() = " + pNames.size());
        for (WebElement productName : pNames) {
            System.out.println(productName.getText());
        }
        driver.navigate().refresh();
        System.out.println("2pNames.size() = " + pNames.size());
        pNames.get(0).click();
    }

    @Test
    public void test2_FindByVsFindBys(){
        driver.get(locators.url);
        Utils.sleep(2000);
        locators.elementsAndPrices.forEach(e-> System.out.println(e.getText()));
        System.out.println("-------");
        locators.elementUnderElements.forEach(e-> System.out.println(e.getText()));
    }


    @Test
    public void test3_fillTheProductClass(){
        driver.get(locators.url);
        Utils.sleep(2000);

        List<Product> products = new ArrayList<>();

        for (WebElement product : locators.products) {

            WebElement link = product.findElement(By.cssSelector("h4>a"));
            String name = link.getText();
            String priceStr = product.findElement(By.cssSelector("h5")).getText();
            int price = Integer.parseInt(priceStr.replaceAll("[^0-9]","").trim());
            String description = product.findElement(By.id("article")).getText();

            products.add(new Product(link, name, price, description));
        }

        for (Product product : products) {
            System.out.println(product);
        }

        products.get(0).getLink().click();
    }
}
