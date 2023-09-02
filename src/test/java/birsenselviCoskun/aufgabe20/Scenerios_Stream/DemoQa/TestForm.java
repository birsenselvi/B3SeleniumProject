package birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

import static birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa.Locators.*;


public class TestForm extends BaseTest {

    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() {

        driver.get(url);

        sendkeys(lfirstName, "Turgut");
        sendkeys(lLastName, "Zor");
        sendkeys(lUserEmail, "deneme@deneme.com");

        clickByAction(clickGender("Male"));

        sendkeys(lPhoneNumber, "0687453612");

        DateOfBirth.input(driver, lDateOfBirth).selectDate("1993", "April", 15);
        scrollBy(500);
        selectSubject("Maths", "Arts");

        selectHobby("Sports","Music");

        String UFile="C:/Users/birsenselvicoskun/Documents/Desktop/Screenshot_2023_08_30-9.png";

        sendkeys(lFileUpload,UFile);

        String win = driver.getWindowHandle();

        clickByJs(lSubmit);
        clickByJs(lModalDialoge);

        /*
         (reklam cikmasina conelik onlem icin)
        String wins = driver.getWindowHandles().stream()
                .filter(e->!e.equalsIgnoreCase(win)).findFirst().get();

        driver.switchTo().window(wins);
        driver.switchTo().window(win);

         */




    }

    public void clickByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        new Actions(driver).scrollToElement(element).moveToElement(element).click().perform();
    }

    public void selectSubject(String... subjects)//varak ile parametre göndeildi birden fazla secenek oldugu icin
     {
        WebElement subjectInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lSubjects));
        for (String subject : subjects) {
            By lSubjectItem = By.xpath("//div[starts-with(@class,'subjects-auto-complete') and text()='" + subject + "']");
            new Actions(driver).sendKeys(subjectInput, subject).perform();
            WebElement subjectItem = wait.until(ExpectedConditions.visibilityOfElementLocated(lSubjectItem));
            new Actions(driver).click(subjectItem).perform();
        }
    }

    public void selectHobby(String... hobbies) {
        String locator = "//div[./label[contains(., '%s')]]//input"; // '%s' bu locator icin stringi aramak icin belirtec

        for (String hobby : hobbies) {
            clickByJs(By.xpath(String.format(locator, hobby)));
        }
    }



}
