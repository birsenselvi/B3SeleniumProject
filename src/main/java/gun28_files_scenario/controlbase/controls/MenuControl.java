package gun28_files_scenario.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MenuControl extends BaseControl{

    static String XPATH_SIDEMENU = "//nav[@aria-label='Sidepanel']//a[.='%s']";
    static String XPATH_TOPMENU = "//nav[@aria-label='Topbar Menu']//li[.//span[contains(.,'Job')]]";

    private MenuControl(By locator){
        super(locator);;
    }

    public static MenuControl fromLabel(String label){
        return fromLabel(label, 1);
    }

    public static MenuControl fromLabel(String label, int index){
        String xpath1 = String.format(XPATH_SIDEMENU, label);
        String xpath2 = String.format(XPATH_TOPMENU, label);

        String xpath = "(" + xpath1 + " | " + xpath2 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        MenuControl control = new MenuControl(locator);
        control.label = label;
        return control;
    }

    public void select(String option){
        click();
        ButtonControl.fromLabel(option).click();
    }

    public void hover(){
        new Actions(driver)
                .moveToElement(element)
                .perform();
    }


}
