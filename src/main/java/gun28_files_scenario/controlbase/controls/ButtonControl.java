package gun28_files_scenario.controlbase.controls;

import org.openqa.selenium.By;

public class ButtonControl extends BaseControl{

    static String XPATH_BUTTON1 = "//button[contains(., '%s')]";
    static String XPATH_LINK = "//a[.='%s']";

    private ButtonControl(By locator){
        super(locator);
    }

    public static ButtonControl fromLabel(String label){
        return fromLabel(label, 1);
    }

    public static ButtonControl fromLabel(String label, int index){
        String xpath_button1 = String.format(XPATH_BUTTON1, label);
        String xpath_link = String.format(XPATH_LINK, label);

        String xpath = "(" + xpath_button1 + " | " + xpath_link + ")[" + index + "]";
        By locator = By.xpath(xpath);
        ButtonControl control = new ButtonControl(locator);
        control.label = label;
        return control;
    }

    public String getText(){
        return element.getText();
    }




}
