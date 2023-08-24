package gun16;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestTricentis {


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
