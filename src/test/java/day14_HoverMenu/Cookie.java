package day14_HoverMenu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class Cookie extends BaseTest {
    /**
     *         https://yahoo.com sayfasina gidin
     *         cookieleri kabul edin
     *         searchbox'a "guidersoft" yazin ve aratin
     *         Guidersoft sayfasinda footer da bulunan "courses" linkine tiklayin
     *         acilan sayfada kurs basliklarini bir ArrayListe atin
     *         yahoo sayfasina dönün
     *         sayfayi kapatin
     *         guidersoft sayfasina dönün
     *         home linkine tiklayin, home sayfasina gittiginizi assert edin
     *         driveri kapatin
     */
    {
        driver = utils.Driver.getDriver();
    }
    String url = "https://yahoo.com ";

    @Test
    public void test2(){
        driver.manage().window().maximize();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By lbutton = By.xpath("//button[@value='agree']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lbutton)).click();

        // searchbox'a "guidersoft" yazin ve aratin
        By lSearchbox = By.cssSelector("input[name='p'");
        driver.findElement(lSearchbox).sendKeys("Guidersoft");

        By lInput = By.xpath("//button[@id='ybar-search']");
        driver.findElement(lInput).click();

        // Guidersoft linkine tiklayin.
        By lGuiderSoftLink = By.xpath("(//h3/a[contains(text(), 'Guider Soft')])[1]");
        click(lGuiderSoftLink);

        String winYahoo = driver.getWindowHandle();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> wins = driver.getWindowHandles();
        String winGuider = driver.getWindowHandles()
                .stream()
                .filter(w->!w.contains(winYahoo))
                .findFirst()
                .get();

        // Guidersoft sayfasinda footer da bulunan "courses" linkine tiklayin
        driver.switchTo().window(winGuider);
        By lCourses = By.xpath("//footer//a[text()='Courses']");
        scrollIntoView(lCourses);
        click(lCourses);


        //        acilan sayfada kurs basliklarini bir ArrayListe atin
        By lCourseList = By.cssSelector(".course-title > a");
        List<WebElement> courses = driver.findElements(lCourseList);

        courses.forEach(e -> System.out.println(e.getText()));

        //        yahoo sayfasina dönün
        driver.switchTo().window(winYahoo);

        //        sayfayi kapatin
        driver.close();

        //        guidersoft sayfasina dönün
        driver.switchTo().window(winGuider);

        //        home linkine tiklayin, home sayfasina gittiginizi assert edin
       /* By lHome = By.xpath("//nav[not(contains(@class,'mobile'))]//a[text()='Home']");
        click(lHome);*/

        List<WebElement> elements = driver.findElements(By.xpath("//nav//a[text()='Home']"));

        WebElement homeButton = elements.stream().filter(e -> e.isDisplayed()).findFirst().get();
        homeButton.click();

        //        driveri kapatin
        driver.quit();
    }
}

