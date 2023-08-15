package gun12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Tests {

    WebDriver driver = new ChromeDriver();

    @Test
    public void testSelectLabel(){

        String url = "https://demoqa.com/selectable";
        driver.manage().window().maximize();

        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By lLabels = By.cssSelector("#verticalListContainer li");

        //List<WebElement> labels = driver.findElements(lLabels);
        List<WebElement> labels = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lLabels));


        labels.get(new Random().nextInt(4)).click();

        Utils.sleep(3000);

        labels = driver.findElements(lLabels);

        labels.forEach(e -> {
            if (e.getAttribute("class").contains("active"))
                e.click();
        });

        // labellarin textlerini yazdirin
        List<String> labelTexts = labels.stream().map(e -> e.getText()).collect(Collectors.toList());
        System.out.println(labelTexts);

        driver.quit();
    }


    @Test
    public void clickButons(){

        String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By[] locators = {
                By.cssSelector("#button00"),
                By.cssSelector("#button01"),
                By.cssSelector("#button02"),
                By.cssSelector("#button03")
        };

        for (int i = 0; i < locators.length; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators[i])).click();
        }

        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");

        driver.quit();

    }

    @Test
    public void clickButons1(){

        String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
        driver.get(url);

        By[] locators = {
                By.cssSelector("#button00"),
                By.cssSelector("#button01"),
                By.cssSelector("#button02"),
                By.cssSelector("#button03")
        };

        for (int i = 0; i < locators.length; i++) {
            click(locators[i]);
        }

        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");

        driver.quit();

    }

    public void click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}
