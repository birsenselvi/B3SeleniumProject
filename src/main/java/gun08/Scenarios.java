package gun08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Scenarios {

    WebDriver driver;


    //instance initializer, constructordan hemen önce calisir
    {
        driver = getDriver();
        driver.manage().window().maximize();
    }

    String url = "https://demoqa.com/";
    By lElements = By.xpath("//div[@class='category-cards']/div[.//*[text()='Elements']]");
    //By lElements = By.xpath("//div[@class='card mt-4 top-card' and .//h5[text()='Elements']]");
    By lWebTables = By.xpath("//ul/li[.//span[text()='Web Tables']]");


    @Test
    public void scenario1(){
        /*
            https://demoqa.com/
            Elements linkine tiklayin
            Web Tables'a tiklayin
            Last Name'i Vega olan kaydi silin.
            Kaydin silindigini assert edin
         */

        driver.get(url);
        scrollBy(500);
        driver.findElement(lElements).click();

        scrollBy(600);
        driver.findElement(lWebTables).click();

        By lDeleteButton = getXPathOf("Vega", false);
        driver.findElement(lDeleteButton).click();
        sleep(500);

        // silme assertion'i icin 1 yol
        List<WebElement> buttons = driver.findElements(getXPathOf("Vega"));
        Assert.assertEquals(buttons.size(), 0);

        // silme assertion'i icin 2 yol
        boolean isExists = false;
        try {
            driver.findElement(getXPathOf("Vega"));
            isExists = true;
        }catch (Exception e){
            System.out.println("msg");
        }
        Assert.assertFalse(isExists);


        sleep(3000);
        driver.quit();
    }



    @Test
    public void testEdit(){
        // https://demoqa.com/
        driver.get(url);

        // Elements linkine tiklayin
        scrollBy(500);
        driver.findElement(lElements).click();

        // Web Tables'a tiklayin
        scrollBy(700);
        driver.findElement(lWebTables).click();

        // Last Name'i Vega olan kaydi edit edin.
        driver.findElement(getXPathOf("Vega")).click();
        sleep(300);

        // Acilan dialogbox daki formu gerekli bilgiler ile doldurun
        // First Name'i degistirin
        WebElement name = driver.findElement(getXpathOfInput("First Name"));
        name.clear();
        name.sendKeys("New Name");

        // Submit butonuna basin ve kayidi gücelleyin
        // //div[@class='modal-content']//button[@id='submit']
        driver.findElement(By.id("submit")).click();

        // Ismin güncellendigini asser edin.
        sleep(200);
        driver.findElement(getXPathOf("New Name"));

        sleep(5000);
        driver.quit();
    }

    @Test
    public void testEdit2(){
        driver.get(url);

        scrollBy(500);
        click(lElements);

        scrollBy(700);
        click(lWebTables);

        click(getXPathOf("Vega"));
        sleep(300);

        sendkey(getXpathOfInput("First Name"),"New Name");

        click(By.id("submit"));

        sleep(200);
        getElement(getXPathOf("New Name"));

        sleep(5000);
        driver.quit();
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendkey(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public By getXpathOfInput(String label){
        return By.xpath("//div[@class='modal-content']//label[contains(.,'" + label + "')]//ancestor::div[@id]//input");
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public By getXPathOf(String name){
        return getXPathOf(name, true);
    }

    public By getXPathOf(String name, boolean edit){
        if (edit)
            return By.xpath("//div[text()='" + name + "']//parent::div//span[@title='Edit']");
        else
            return By.xpath("//div[text()='" + name + "']//parent::div//span[@title='Delete']");
    }

    public void scrollBy(int y){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, " + y + ")");
    }

    public WebDriver getDriver(){
        return getDriver("chrome");
    }

    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

}
