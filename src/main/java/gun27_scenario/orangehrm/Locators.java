package gun27_scenario.orangehrm;

import org.openqa.selenium.By;

public class Locators {

    public static final String url = "https://opensource-demo.orangehrmlive.com/";

    public static By input(String label){
        return input(label, 1);
    }

    public static By input(String label, int index){
        String xpath1 = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'" + label + "')]]//input";
        String xpath2 = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'" + label + "')]]//input";

        String xpath = "(" + xpath1 + " | " + xpath2 + ")[" + index + "]";
        return By.xpath(xpath);
    }

    public static By button(String label){
        String xpath = "//button[contains(., '" + label + "')]";
        return By.xpath(xpath);
    }
}
