package gun23_testng_xml.xml2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Test1 extends TestBaseClass{

    By lUsername = By.xpath("//input[@name='username']");
    By lPassword = By.xpath("//input[@name='password']");
    By lButton = By.xpath("//button[text()=' Login ']");
    By lUser = By.cssSelector(".oxd-userdropdown");

    @Test
    public void test1(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lUsername));
    }

    @Test(dependsOnMethods = "test1")
    public void fillLoginForm(){
        driver.findElement(lUsername).sendKeys("Admin");
        driver.findElement(lPassword).sendKeys("admin123");
        driver.findElement(lButton).click();
    }

    @Test(dependsOnMethods = "fillLoginForm")
    public void assertLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUser));
    }


}
