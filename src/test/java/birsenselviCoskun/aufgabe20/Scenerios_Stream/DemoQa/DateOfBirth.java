package birsenselviCoskun.aufgabe20.Scenerios_Stream.DemoQa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;


import java.time.Duration;

public class DateOfBirth extends BaseTest {

    WebElement takvimRoot;
    By inputLocator;
    By lTakvimRoot = By.cssSelector(".react-datepicker");
    By lYear = By.cssSelector(".react-datepicker__year-select");
    By lMonth = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select");

    String lDayString = ".//div[contains(text(),'%s')]";

    public static DateOfBirth input(WebDriver driver, By inputLocator) {

        return new DateOfBirth(driver, inputLocator);

    }

    private DateOfBirth(WebDriver driver, By inputLocator) {
        this.driver = driver;
        this.inputLocator = inputLocator;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    public void selectDate(String year, String mount, int day) {
        //clickByAction(inputLocator);
        takvimRoot = wait.until(ExpectedConditions.visibilityOfElementLocated(lTakvimRoot));

        Select selectYear = new Select(takvimRoot.findElement(lYear));
        selectYear.selectByVisibleText(year);

        Select selectMount = new Select(takvimRoot.findElement(lMonth));
        selectMount.selectByVisibleText(mount);

        By lDay = By.xpath(String.format(lDayString, day));

        takvimRoot.findElement(lDay).click();


    }




}
