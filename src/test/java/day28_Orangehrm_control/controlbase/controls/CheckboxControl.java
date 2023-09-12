package day28_Orangehrm_control.controlbase.controls;

import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.Driver;

import javax.swing.*;

public class CheckboxControl extends BaseControl {

    static String MENU = "//nav[@aria-label='Topbar Menu']//li[.//span[contains(.,'Configuration')]]//li[.//a[contains(.,'%s')]]";
    static String checkbox = "//div[@class='orangehrm-module-field-row' and .//p[text()='%s']]//div[@class='oxd-switch-wrapper']";
    private CheckboxControl(By locator){
        super(locator);;
    }

    public void select(String label){
        click();
        String xpath = String.format(MENU, label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public static CheckboxControl check(){
      return check("Admin Module");
    }

    public static CheckboxControl check(String name){
        String xpath = String.format(checkbox,name);
        By locator = (By.xpath(xpath));
        CheckboxControl control = new CheckboxControl(locator);
        control.click();
       return control;
    }

    public static void control(String name){
        String xpath = String.format(checkbox, name);
        By locator = By.xpath(xpath);




    }
}
