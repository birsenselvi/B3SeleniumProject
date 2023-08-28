package gun21_testng.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {


    public String url = "https://demoblaze.com/";


    /*
    Locators(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
     */

    @FindBy(xpath = "//a[text()='Phones']")
    public WebElement phonesLink;              // driver.findElement()

    @FindBy(css = ".card-title>a")
    public List<WebElement> productNames;      // driver.findElements()

    /*
    @FindBy(css = ".card-title>a")
    WebElement productName;             // bulunan tüm elementlerden ilkini alir
    */

    // @FindAll icindeki @FindBy'lar ile belirtilen tüm elementler
    // ayri ayri elementleri bulur
    @FindAll({
            @FindBy(css = ".card-block h4"),
            @FindBy(css = ".card-block h5")
    })
    List<WebElement> elementsAndPrices;


    // ilk element altinda digerini arar
    @FindBys({
            @FindBy(css = ".card-block"),
            @FindBy(css = "h5")
    })
    List<WebElement> elementUnderElements;

    @FindBy(css = "#tbodyid>div")
    List<WebElement> products;


}
