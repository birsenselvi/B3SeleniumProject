package gun03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _01DriverDefinition {

    public static void main(String[] args) {

        // edge driver setup ediliyor
        //WebDriverManager.edgedriver().setup();

        // EdgeDriverin bir instance'ini create ediyoruz
        WebDriver driver = new EdgeDriver();

        // driver'a https://google.com adresine git diyoruz.
        driver.get("https://google.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
