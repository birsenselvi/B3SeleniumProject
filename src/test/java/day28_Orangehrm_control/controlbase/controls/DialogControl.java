package day28_Orangehrm_control.controlbase.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DialogControl extends BaseControl {

    static String DIALOG = "//div[@role='dialog']";
    static String XBUTTON = "//button[contains(@class,'oxd-dialog-close-button')]";
    static String BUTTON = "//button[contains(.,'%s')]";
    static String TITLE = "//p[contains(@class, \"title\")]";
    static String BODY = "//p[contains(@class, 'body')]";

    public static DialogControl find(){
        By locator = By.xpath(DIALOG);
        DialogControl control = new DialogControl(locator);
        control.label = "";
        return control;
    }

    private DialogControl(By locator){
        super(locator);

    }

    public void click(String label){
        String xpath = DIALOG + String.format(BUTTON, label);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public void close(){
        String xpath = DIALOG + XBUTTON;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public String getDialogTitle(){
        String xpath = DIALOG + TITLE;
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getDialogBody(){
        String xpath = DIALOG + BODY;
        return driver.findElement(By.xpath(xpath)).getText();
    }

}
