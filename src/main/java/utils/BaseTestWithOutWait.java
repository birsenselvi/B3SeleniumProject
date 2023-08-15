package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Bu class istedigimiz testlerimizde kullanabilecegimiz parent classdir.
 * Testlerde kullanacagimiz WebDriver ve kullanacagimiz methodlari yazabiliriz.
 */
public class BaseTestWithOutWait {

    /**
     * child classlarda kullanilacak driver
     */
    protected WebDriver driver;

    /**
     * ihtiyac durumunda kullanilmak üzere olusturulan Thread.sleep methodu
     * Otomasyonda zorunlu olmadikca kullnilmamasi önerilir
     * default 1000ms = 1sn ile overload sleep(long milis) cagrilmistir.
     */
    public void sleep(){
        sleep(1000);
    }

    /**
     * aldigi ms süresince Thread'i durdurur.
     * @param milis milisecond olarak bekleme süresi
     */
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendkeys(By locator, CharSequence...text){
        WebElement eUsername = driver.findElement(locator);
        eUsername.clear();
        eUsername.sendKeys(text);
    }

    public void scrollBy(int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + y + ");");

    }


    public void scrollTo(int y){
        scrollTo(0, y);
    }


    public void scrollTo(int x, int y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(" + x + ", " + y + ");");

    }

    public void scrollIntoView(WebElement element){
        scrollIntoView(element, true);
    }


    public void scrollIntoView(WebElement element, boolean up){
        String pos = up ? "true" : "false";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(" + pos + ");", element);

        /*
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(" + up + ");", element);
        */
    }

    public void clickByJs(By locator){
        WebElement element = driver.findElement(locator);
        clickByJs(element);
    }

    public void clickByJs(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
}
