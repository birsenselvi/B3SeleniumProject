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

public class TestTricentis1 {


    @Test
    public void test1() throws IOException {

        TricentisHomePage hp = new TricentisHomePage();

        hp.open();

        hp.checkTitle("Demo Web Shop");

        hp.search("comp");

        List<WebElement> results = hp.getProductList();
        Assert.assertEquals(results.size(), 7);

        List<WebElement> resultsWithAddToCart = new ArrayList<>();
        for (WebElement result : results) {
            try {
                By atc = By.xpath(".//input[@value='Add to cart']");
                result.findElement(atc);
                resultsWithAddToCart.add(result);
            }catch (Exception ignored){}
        }

        hp.takeScreenShot();
        hp.takeElementScreenShot(results.get(0));

        Utils.sleep(3000);
        Driver.quit();
    }


}
