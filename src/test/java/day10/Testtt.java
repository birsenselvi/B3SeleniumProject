package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Testtt {
    WebDriver driver;
    String url = "https://demoqa.com/selectable";
    @Test
    public void test2(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By lLabels = By.xpath("//ul[@id='verticalListContainer']/li");
        By lInputBox = By.cssSelector("li.mt-2.list-group-item.active.list-group-item-action");
        List<WebElement> listText = driver.findElements(lLabels);
        listText.get(new Random().nextInt(4)).click();
        listText.forEach(e-> System.out.println(e.getAttribute("background-color")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lInputBox));
        System.out.println(driver.findElement(lInputBox).getText());
        driver.findElement(lInputBox).click();






        driver.quit();


    }
}
