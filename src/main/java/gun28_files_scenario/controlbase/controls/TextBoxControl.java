package gun28_files_scenario.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBoxControl extends BaseControl{

    static String XPATH_TEXTBOX1 = "//div[contains(@class, 'oxd-input-group ') and .//*[contains(text(),'%s')]]//input";

    private TextBoxControl(By locator){
        super(locator);;
    }

    public static TextBoxControl fromLabel(String label){
        String xpath = String.format(XPATH_TEXTBOX1, label);
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

    public TextBoxControl sendkeys(CharSequence...text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        return this;
    }

    public void click(){

    }
}
