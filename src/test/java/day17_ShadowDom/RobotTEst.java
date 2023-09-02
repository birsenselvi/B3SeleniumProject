package day17_ShadowDom;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotTEst extends BaseTest {


    {
        driver = utils.Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://the-internet.herokuapp.com/";
    By basicAuth = By.linkText("Basic Auth");


    @Test
    public void testt() throws AWTException {

        driver.get(url);
        driver.findElement(basicAuth).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));

        sleep(2000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));
        robot.keyPress(KeyEvent.VK_TAB);

        sleep(2000);
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));

        sleep(2000);
        driver.quit();


    }
}
