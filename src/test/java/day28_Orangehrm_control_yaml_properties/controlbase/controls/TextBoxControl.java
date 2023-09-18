package day28_Orangehrm_control_yaml_properties.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBoxControl extends BaseControl {

    static String XPATH_TEXTBOX1 = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'%s')]]//input";

    static String OPTION = "//div[@role='listbox']//div[@role='option' and .//span[contains(text(),'%s')]]";

    private TextBoxControl(By locator){
        super(locator);
    }

    public static TextBoxControl fromLabel(String label){
        return fromLabel(label, 1);
    }

    public static TextBoxControl fromLabel(String label, int index){
        String xpath1 = String.format(XPATH_TEXTBOX1, label);
        String xpath = "(" + xpath1 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        TextBoxControl control = new TextBoxControl(locator);
        control.label = label;
        return control;
    }

    public static TextBoxControl fromLocator(By locator){
        TextBoxControl control = new TextBoxControl(locator);
        control.label = "";
        return control;
    }

    public void select(String optionText){
        sendKeys(optionText);
        String xpath = String.format(OPTION, optionText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();

    }

}
