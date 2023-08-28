package gun21_testng.demoblaze;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.WebElement;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private WebElement link;
    private String name;
    private int price;
    private String description;

    @Override
    public String toString() {
        return "Product:\n" +
                "name: " + name + " \n" +
                "price: " + price + "\n" +
                "description: " + description + "\n";
    }
}
