package gun04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01DriverMethods {

    public static void main(String[] args) {

        // driver tanimlandi
        WebDriver driver = new ChromeDriver();

        // guidersoft sayfasina gidildi
        driver.get("https://guidersoft.com/");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
