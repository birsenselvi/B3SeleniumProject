package day28_Orangehrm_control_yaml_properties.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropDownControl extends BaseControl {

    static String XPATH_DROPDOWN1 = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'%s')]]//div[@class='oxd-select-wrapper']";
    static String OPTION = "//div[@role='listbox']//div[@role='option' and .//span[contains(text(),'%s')]]";

    public static DropDownControl fromLabel(String label){
        return fromLabel(label, 1);
    }

    public static DropDownControl fromLabel(String label, int index){
        String xpath1 = String.format(XPATH_DROPDOWN1, label);

        String xpath = "(" + xpath1 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        DropDownControl control = new DropDownControl(locator);
        control.label = label;
        return control;
    }

    public static DropDownControl fromLocator(By locator){
        DropDownControl control = new DropDownControl(locator);
        control.label = "";
        return control;
    }

    private DropDownControl(By locator){
        super(locator);
    }

    public void select(String label){
        click();
        String xpath = String.format(OPTION, label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
}
