package day27_senerio_yapilacak;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locator {

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;


    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[text()=' Login ']")
    WebElement login;

    @FindBy(xpath="//h6")
    WebElement logAssert;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement add;

    @FindBy(xpath = "//div[text()='-- Select --']")
    WebElement select;

    @FindBy(xpath = "//span[text()='ESS']//parent::div" )
    WebElement ess;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement name;


    @FindBy(xpath = "//span[text()='Enabled']")
    WebElement enable;

    @FindBy(xpath = "//span[text()='Lisa  Andrews']")
    WebElement lisa;
    /*Locator() {
        PageFactory.initElements(Driver.getDriver(), this);
    }*/
}
