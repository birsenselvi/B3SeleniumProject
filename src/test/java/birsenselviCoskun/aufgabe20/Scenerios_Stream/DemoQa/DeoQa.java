package birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DeoQa {
    /**
     * Odev:
     *     1.  https://demoqa.com/automation-practice-form
     *     2.  Sayfadaki form elementlrtini doldurunuz
     *     3.  Takvim kismini ayri bir class/Method ile yapabilirsiniz (optional)
     *     4.  Upload islemini ilgili field'a dosya yolu ve adi sendkey yaparak yapilabilir.
     *     5.  islemde elementlere scrollIntoView yapilabilir.
     *         Reklamlar problem olusturuyor ise, scrollIntoView sonrasi scrollBy ile
     *         bir miktar daha kaydirma yapilabilir
     *     6.  Click islemleri, selenium, Actions ya da JS ile yapilabilir
     *     7.  submit sonrasi bilgileri ihtiva eden dialo'un acildigini assert edin
     */

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url = "https://demoqa.com/automation-practice-form";
    By lFirstName = By.cssSelector("#firstName");
    By lHobbies = By.xpath("//label[text()='Sports']");



    @Test
    public void test1(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);


        WebElement firsName = driver.findElement(lFirstName);
        WebElement hobbysSports = driver.findElement(lHobbies);


        actions = new Actions(driver);
        actions.click(firsName)
                .sendKeys("ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("deneme@deneme.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("1234567890")
                .sendKeys(Keys.TAB)
                .sendKeys("15April1993")
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("konu yok")
                .click(hobbysSports)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys().click()
                .perform();



    }



    public void zoom(int num){
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='" + num+ "%'");
    }

    public void scrollBy(int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + y + ");");

    }

}
