package day20_FindBy.withBy;

import lombok.*;
import org.openqa.selenium.WebElement;
@Getter
@Setter
@ToString@NoArgsConstructor
@AllArgsConstructor
public class Product {
    WebElement name;
    String text;
    double preis;
    WebElement addToCart;

}
