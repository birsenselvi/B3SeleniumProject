package gun20.pom.withBy;

import lombok.*;
import org.openqa.selenium.WebElement;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private WebElement name;
    private String text;
    private double price;
    private WebElement addToCart;

}
