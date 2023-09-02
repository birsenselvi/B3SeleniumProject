package birsenselviCoskun.aufgabe15;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class _01 extends BaseTest {
    /**
     *     https://demoqa.com/sortable   sayfasina gidin
     *     actions ile 300 px scroll yapin
     *     DregDrop ile "One",....,"Six" siralamasini "Six",..,"One" olacak sekilde degistirin
     */
    {
        driver= utils.Driver.getDriver();
        driver.manage().window().maximize();
        // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    String url = "https://demoqa.com/sortable ";

    @Test
    public void test(){
        driver.get(url);

        By lsource1 = By.xpath("//div[text() ='One']");
        WebElement source1 = driver.findElement(lsource1);
        By lsource2 = By.xpath("//div[text() ='Six']");
        WebElement source2 = driver.findElement(lsource2);
        By lsource3 = By.xpath("//div[text() ='Five']");
        WebElement source3 = driver.findElement(lsource3);


        new Actions(driver)
                .scrollByAmount(0,300)
                .dragAndDrop(source1, source2)
                .dragAndDrop(source3, source1)
                .perform();



    }

}
