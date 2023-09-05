package gun27_scenario.orangehrm;

import org.openqa.selenium.By;

public class Locators {

    public static final String url = "https://opensource-demo.orangehrmlive.com/";

    public static By input(String label){
        String xpath = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'" + label + "')]]//input";
        return By.xpath(xpath);
    }

    public static By button(String label){
        String xpath = "//button[contains(., '" + label + "')]";
        return By.xpath(xpath);
    }
}
