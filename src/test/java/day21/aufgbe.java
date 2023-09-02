package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class aufgbe {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demoqa.com/progress-bar";

    @BeforeClass
    public void befortesst() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void getUrl() {
        driver.get(url);
    }
    @FindBy(id = "startStopButton")
    WebElement startButton;

    @FindBy(css= "#progressBar>div")
    WebElement progresbar;




    @Test
    public void testt() {

        getUrl();
        startButton.click();

    }
    @Test(dependsOnMethods = {"testt"})
    public void testt2(){
        int prozent;
        do {
           String val = progresbar.getAttribute("aria-valuenow");
           prozent = Integer.parseInt(val);
        }while(prozent<=80);

        startButton.click();

    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
