package gun10;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTestWithOutWait;
import utils.Driver;

public class ButtonTest extends BaseTestWithOutWait {

    /*
        http://uitestingplayground.com/textinput
        Inputbox'a random bir text girin
        Butona tiklayin
        Butonun texttinin girdiginiz text oldugunu assert edin
     */

    String url = "http://uitestingplayground.com/textinput";
    By input = By.cssSelector("#newButtonName");
    By button = By.cssSelector("#updatingButton");



    @Test
    public void buttonTest(){
        driver = Driver.getDriver();

        driver.get(url);

        for (int i = 0; i < 5; i++) {
            String text = RandomStringUtils.randomAlphabetic(5, 10);
            sendkeys(input, text);
            click(button);
            sleep(300);
            Assert.assertEquals(driver.findElement(button).getText(), text);
            sleep();
        }


        driver.quit();

    }




    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomAlphanumeric(10, 15));
    }

}
