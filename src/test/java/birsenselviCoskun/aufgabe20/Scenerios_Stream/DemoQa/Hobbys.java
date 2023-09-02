package birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class Hobbys extends BaseTest {
    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test(){
        driver.get(" https://demoqa.com/automation-practice-form");
        seleckHobby(0,1);
    }
    public void seleckHobby(int a, int b){
        List<WebElement> hobbies = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//input"));
        clickByJs(hobbies.get(a));
        clickByJs(hobbies.get(b));

    }
    public void seleckHobby(int a){
        List<WebElement> hobbies = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//input"));
        clickByJs(hobbies.get(a));

    }
    public void seleckHobby(int a, int b, int c){
        List<WebElement> hobbies = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//input"));
        clickByJs(hobbies.get(a));
        clickByJs(hobbies.get(b));
        clickByJs(hobbies.get(c));

    }
}
