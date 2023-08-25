package gun20.pom.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage{

    private By products = By.cssSelector(".inventory_item");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productPrice = By.cssSelector(".inventory_item_price");
    private By productAddToCart = By.cssSelector(".inventory_item button");

    public ProductPage(WebDriver driver){
        super(driver);
    }


    public List<String> getListOfProductNames(){
        return driver.findElements(productName)
                .stream()
                .map(e->e.getText())
                .collect(Collectors.toList());
    }

}
