package day28_Orangehrm_control.controlbase.controls;

import org.openqa.selenium.By;

public class RadioControl extends BaseControl{

    static String Xpath_Titel = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[.//label[contains(.,'%s')]]";

    static String local = "//input";
    private RadioControl(By locator) {
        super(locator);
    }

    public static RadioControl text(String label){
        return text(label, 1);
    }
    public static RadioControl text(String label, int index){
        String xpath_button1 = String.format(Xpath_Titel, label);
        String xpath_link = String.format(local, label);

        String xpath = "(" + xpath_button1 + " | " + xpath_link + ")[" + index + "]";
        By locator = By.xpath(xpath);
        RadioControl control = new RadioControl(locator);
        control.label = label;
        return control;
    }

    /*public void static sendKeys(By locator, String text){
        return
    }*/
}
