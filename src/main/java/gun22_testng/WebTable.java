package gun22_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.List;


public class WebTable extends BaseTest {
    /*
        1.  https://demoqa.com/webtables
        2.  Tablodaki tüm verileri siliyoruz
        3.  DataProvider ile yeni datalar girin
        4.  FirstName e göre siralayin ve screenschot alin.
     */

    String url = "https://demoqa.com/webtables";
    By lDelButtons = By.cssSelector("span[id^='delete-record']");
    By lAddNewRecordButton = By.id("addNewRecordButton");

    By lFirstName = By.cssSelector("#firstName-wrapper input");
    By lLastName = By.cssSelector("#lastName-wrapper input");
    By lEMail = By.cssSelector("#userEmail-wrapper input");
    By lAge = By.cssSelector("#age-wrapper input");
    By lSalary = By.cssSelector("#salary-wrapper input");
    By lDepartment = By.cssSelector("#department-wrapper input");

    By lRegistrationFormSubmitButton = By.cssSelector("#submit");

    By lSortByName = By.xpath("//div[text()='First Name']");

    @BeforeTest
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test_gotoSite() {
        driver.get(url);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lDelButtons, 1));
    }

    @Test(priority = 1)
    public void test_clearList() {

        List<WebElement> dels = driver.findElements(lDelButtons);

        while (dels.size() > 0) {
            int initialSize = dels.size();
            click(dels.get(0));
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(lDelButtons, initialSize));

            dels = driver.findElements(lDelButtons);
        }

    }

    @Test(dataProvider = "data", priority = 2, enabled = false)
    public void fillTheList(String firstname, String lastname, String email, int age, int salary, String department) {
        click(lAddNewRecordButton);
        sendkeys(lFirstName, firstname);
        sendkeys(lLastName, lastname);
        sendkeys(lEMail, email);
        sendkeys(lAge, String.valueOf(age));
        sendkeys(lSalary, String.valueOf(salary));
        sendkeys(lDepartment, department);
        click(lRegistrationFormSubmitButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lFirstName));
    }

    @Test(dataProvider = "data", priority = 2)
    public void fillTheList2(Object[] items) {
        By[] locators = {lFirstName,lLastName, lEMail, lAge, lSalary, lDepartment};

        click(lAddNewRecordButton);
        for (int i = 0; i < items.length; i++) {
            sendkeys(locators[i], items[i].toString());
        }

        click(lRegistrationFormSubmitButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lFirstName));
    }

    @Test(priority = 3)
    public void finish(){
        click(lSortByName);
        executeScript("document.body.style.zoom='60%';");
        takeScreenShot("DemoQA");
    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][]{
                {"Aguste", "Brayfield", "abrayfield0@purevolume.com", 23, 33472, "Books"},
                {"Melamie", "Lougheid", "mlougheid1@msu.edu", 43, 711717, "Electronics"},
                {"Jerrylee", "Vodden", "jvodden2@naver.com", 45, 48395, "Home"},
                {"Damian", "Gaffney", "dgaffney3@icq.com", 65, 57812, "Beauty"},
                {"Ferdinande", "Woller", "fwoller5@discovery.com", 37, 42795, "Clothing"}
        };
    }

}
