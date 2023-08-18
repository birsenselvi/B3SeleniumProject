package gun14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TestSwitch extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void test1(){

        //        https://yahoo.com sayfasina gidin
        String url = "https://yahoo.com";
        driver.get(url);

        //        cookieleri kabul edin
        By lAcceptCookiesButton = By.cssSelector("button[name='agree']");
        //click(lAcceptCookiesButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lAcceptCookiesButton)).click();

        //        searchbox'a "guidersoft" yazin ve aratin
        By lSearchBox = By.cssSelector("input[name=\"p\"]");
        sendkeys(lSearchBox, "Guidersoft" + Keys.ENTER);

        String winYahoo = driver.getWindowHandle();

        //        Guider Soft linkine tiklayin
        By lGuidersoftLink = By.xpath("(//h3/a[contains(text(), 'Guider Soft')])[1]");
        click(lGuidersoftLink);

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> wins = driver.getWindowHandles();
        String winGuidersoft = driver.getWindowHandles()
                .stream()
                .filter(w -> !w.contains(winYahoo))
                .findFirst()
                .get();


        //        Guidersoft sayfasinda footer da bulunan "courses" linkine tiklayin
        driver.switchTo().window(winGuidersoft);
        By lCourses = By.xpath("//footer//a[text()='Courses']");
        scrollIntoView(lCourses);
        click(lCourses);

        //        acilan sayfada kurs basliklarini bir ArrayListe atin
        By lCourseList = By.cssSelector(".course-title > a");
        List<WebElement> courses = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(lCourseList));

        courses.forEach(e -> System.out.println(e.getText()));

        //        yahoo sayfasina dönün
        driver.switchTo().window(winYahoo);

        //        sayfayi kapatin
        driver.close();

        //        guidersoft sayfasina dönün
        driver.switchTo().window(winGuidersoft);

        //        home linkine tiklayin, home sayfasina gittiginizi assert edin
        By lHome = By.xpath("//nav[not(contains(@class,'mobile'))]//a[text()='Home']");
        click(lHome);

        //        driveri kapatin
        driver.quit();

        /*
        List<WebElement> elements = driver.findElements(By.xpath("//nav//a[text()='Home']"));

        WebElement homeButton = elements.stream().filter(e -> e.isDisplayed()).findFirst().get();
        homeButton.click();
         */
    }




}
