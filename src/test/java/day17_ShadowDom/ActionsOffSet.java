package day17_ShadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class ActionsOffSet extends BaseTest {
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void testtOfset2(){
        driver.get("https://www.snapdeal.com/product/5-feet-soft-teddy-bear/5188147452149964543#bcrumbSearch:teddy%20bear");

        By lImg = By.cssSelector("#bx-slider-left-image-panel");
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(lImg));
        move(img,100,100);
        move(img,-100,100);
        move(img,100,-100);
    }
    public void move(WebElement element, int x, int y){
        new Actions(driver)
                .moveToElement(element, x, y)
                .perform();
    }

    }

