package gun20.testng;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static gun20.testng.Locators.*;

public class Test1 extends Test1Base{



    @Test(priority = 10)
    public void testGoogle(){
        driver.get("https://google.com");

    }

    @Test(priority = 1, dependsOnMethods = {"testGoogle"})
    public void test2(){
        WebElement accept = driver.findElement(Accept_Cookie.getLocator());
        accept.click();
        wait.until(ExpectedConditions.invisibilityOf(accept));

    }

    @Test(dependsOnMethods = {"testGoogle", "test2"})
    public void search(){

        driver.findElement(Searchbox.getLocator()).sendKeys("Guidersoft");
        click(SearchButton.getLocator());
        //driver.findElement(SearchButton.getLocator()).click();

    }




}
