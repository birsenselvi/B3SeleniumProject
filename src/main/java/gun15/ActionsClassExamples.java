package gun15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ActionsClassExamples extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void slider() {
        String url = "https://demoqa.com/slider";
        driver.get(url);

        By lButton = By.xpath("(//div[@id='sliderContainer']//input)[1]");

        WebElement button = wait.until(elementToBeClickable(lButton));
        int len = button.getSize().getWidth() / 2;

        for (int i = -len; i < len; i += 5) {
            moveElementTo(button, i, 0);
            int val = Integer.parseInt(button.getAttribute("value"));
            if (val > 70)
                break;

        }

    }

    public void moveElementTo(WebElement element, int x, int y) {
        new Actions(driver)
                .clickAndHold(element)
                .moveByOffset(x, y)
                .release()
                .perform();
    }

    @Test
    public void sortableLists() {
        String url = "https://demoqa.com/sortable";
        driver.get(url);

        new Actions(driver)
                .scrollByAmount(0, 300)
                .perform();

        trag("List", 6);
        trag("Grid", 9);
        driver.quit();
    }

    public boolean compare(String[] arr, int index){
        Object[] newArr = driver.findElements(By.cssSelector(".list-group-item"))
                .stream()
                .filter(e -> e.isDisplayed())
                .map(e->e.getText())
                .toArray();
        System.out.println(Arrays.toString(newArr));
        int newArrIndex = newArr.length-1;
        for (int i = index-1; i >= 0; i--) {
            if (!arr[i].equals(newArr[newArrIndex-i]))
                return false;
        }
        return true;
    }

    public void trag(String tabHeader, int max) {
        String[] arr = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        click(By.linkText(tabHeader));

        for (int i = max - 1; i >= 1; i--) {
            new Actions(driver)
                    .clickAndHold(getLabel(arr[i]))
                    .pause(200)
                    .moveToElement(getLabel(arr[0]))
                    .pause(200)
                    .release()
                    .perform();
        }
        Assert.assertTrue(compare(arr, max));
    }

    public WebElement getLabel(String num) {
        By locator = By.xpath("//div[text()='" + num + "']");
        return driver.findElements(locator)
                .stream()
                .filter(e -> e.isDisplayed())
                .collect(Collectors.toList())
                .get(0);
    }


    @Test
    public void capitalOrder() {
        String url = "http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
        driver.get(url);

        for (int i = 1; i < 8; i++) {
            By city = By.id("box" + i);
            By country = By.id("box10" + i);
            WebElement source = driver.findElement(city);
            WebElement target = driver.findElement(country);
            wait.until(not(attributeContains(city, "style", "background-color")));
            new Actions(driver)
                    .dragAndDrop(source, target)
                    .pause(300)
                    .build()
                    .perform();

            wait.until(attributeContains(city, "style", "background-color"));
        }
        driver.quit();
    }

}
