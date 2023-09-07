package gun29.myElement;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Utils;

import static gun29.myElement.MyElements.*;

public class MyElementTest {

    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lLoginButton = By.xpath("//button[contains(., 'Login')]");

    @Test
    public void test1(){
        //DriverConfig.browser = "edge";
        //DriverConfig.size = "800x700";

        open(url);

        $(lUsername)
                .shouldBe(Conditions.visible)
                .sendKey("admin");

        $(lPassword)
                .sendKey("admin123");
        $(lLoginButton)
                .shouldBe(Conditions.clickable)
                .hover()
                .click();

    }

    @Test
    public void test2(){
        open("https://www.google.com");
    }

    @Test
    public void test3(){
        open("http://opencart.abstracta.us/");

        String xpath = "(//ul[@class=\"nav navbar-nav\"]/li)[%s]";

        for (int i = 1; i < 9; i++) {
            $(By.xpath(String.format(xpath, i))).hover();
            Utils.sleep(1000);
        }

    }
}
