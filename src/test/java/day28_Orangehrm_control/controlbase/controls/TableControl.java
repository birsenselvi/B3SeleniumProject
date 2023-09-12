package day28_Orangehrm_control.controlbase.controls;

import org.openqa.selenium.By;

public class TableControl extends BaseControl {

    private static final String TABLE = "//div[@role='table']";
    private static final String TABLEHEADER = "//div[@role='table']//div[@class='oxd-table-header']";
    private static final String TABLEROW = "//div[@role='table']//div[@class='oxd-table-body']//div[@class='oxd-table-card' and .//*[contains(., '%s')]]";
    private static final String CHECKBOX = ".//div[@class='oxd-table-card-cell-checkbox']";
    private static final String DELETE = ".//button[.//*[contains(@class,'trash')]]";
    private static final String EDIT = ".//button[.//*[contains(@class,'pencil')]]";


    private TableControl(By locator){
        super(locator);
    }

    public static TableControl findRowWithText(String label){
        return findRowWithText(label, 1);
    }

    public static TableControl findRowWithText(String label, int index){
        String xpath1 = String.format(TABLEROW, label);

        String xpath = "(" + xpath1 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        TableControl control = new TableControl(locator);
        control.label = label;
        return control;
    }

    public void check(){
        element.findElement(By.xpath(CHECKBOX)).click();
    }

    public void delete(){
        element.findElement(By.xpath(DELETE)).click();
    }

    public void edit(){
        element.findElement(By.xpath(EDIT)).click();
    }
}
