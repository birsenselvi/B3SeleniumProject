package gun27_scenario.orangehrm;

import org.testng.annotations.Test;
import static gun27_scenario.orangehrm.Locators.*;


public class Tests extends TestsBase {



    @Test
    public void test1(){
        driver.get(url);
        sendkeys(input("Username"), "Admin");
        sendkeys(input("Password"), "admin123");
        click(button("Login"));

    }
}
